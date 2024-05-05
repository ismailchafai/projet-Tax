import {Component, OnInit, Input} from '@angular/core';
import {ConfirmationService, MessageService} from 'primeng/api';
import {FileTempDto} from 'src/app/zynerator/dto/FileTempDto.model';

import {DatePipe} from '@angular/common';
import {Router} from '@angular/router';
import {Inject, Injectable, PLATFORM_ID} from '@angular/core';


import {environment} from 'src/environments/environment';

import {RoleService} from 'src/app/zynerator/security/shared/service/Role.service';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {StringUtilService} from 'src/app/zynerator/util/StringUtil.service';
import {ServiceLocator} from 'src/app/zynerator/service/ServiceLocator';



import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38Criteria} from 'src/app/shared/criteria/taxe38/TauxTaxe38Criteria.model';
import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleAdminService} from 'src/app/shared/service/admin/taxe38/CategorieLocaleAdmin.service';
@Component({
  selector: 'app-taux-taxe38-create-admin',
  templateUrl: './taux-taxe38-create-admin.component.html'
})
export class TauxTaxe38CreateAdminComponent  implements OnInit {

	protected _submitted = false;
    protected _errorMessages = new Array<string>();

    protected datePipe: DatePipe;
    protected messageService: MessageService;
    protected confirmationService: ConfirmationService;
    protected roleService: RoleService;
    protected router: Router;
    protected stringUtilService: StringUtilService;
    private _activeTab = 0;
    private _file: any;
    private _files: any;



   private _validTauxTaxe38Code = true;
    private _validTypeLocale38DetailCode = true;
    private _validTypeLocale38DetailLibelle = true;
    private _validCategorieLocaleCode = true;
    private _validCategorieLocaleLibelle = true;

	constructor(private service: TauxTaxe38AdminService , private typeLocale38DetailService: TypeLocale38DetailAdminService, private categorieLocaleService: CategorieLocaleAdminService, @Inject(PLATFORM_ID) private platformId? ) {
        this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
    }

    ngOnInit(): void {
        this.typeLocale38DetailService.findAll().subscribe((data) => this.typeLocale38Details = data);
        this.categorieLocaleService.findAll().subscribe((data) => this.categorieLocales = data);
    }


    public save(): void {
        this.submitted = true;
        this.validateForm();
        if (this.errorMessages.length === 0) {
            this.saveWithShowOption(false);
        } else {
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs sur le formulaire'});
        }
    }

    public saveWithShowOption(showList: boolean) {
        this.service.save().subscribe(item => {
            if (item != null) {
                this.items.push({...item});
                this.createDialog = false;
                this.submitted = false;
                this.item = new TauxTaxe38Dto();
            } else {
                this.messageService.add({severity: 'error', summary: 'Erreurs', detail: 'Element existant'});
            }

        }, error => {
            console.log(error);
        });
    }


    public hideCreateDialog() {
        this.createDialog = false;
        this.setValidation(true);
    }





    public  setValidation(value: boolean){
        this.validTauxTaxe38Code = value;
    }



    public  validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTauxTaxe38Code();
    }

    public validateTauxTaxe38Code(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validTauxTaxe38Code = false;
        } else {
            this.validTauxTaxe38Code = true;
        }
    }


    public async openCreateTypeLocale38Detail(typeLocale38Detail: string) {
    const isPermistted = await this.roleService.isPermitted('TypeLocale38Detail', 'add');
    if(isPermistted) {
         this.typeLocale38Detail = new TypeLocale38DetailDto();
         this.createTypeLocale38DetailDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateCategorieLocale(categorieLocale: string) {
    const isPermistted = await this.roleService.isPermitted('CategorieLocale', 'add');
    if(isPermistted) {
         this.categorieLocale = new CategorieLocaleDto();
         this.createCategorieLocaleDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get typeLocale38Detail(): TypeLocale38DetailDto {
        return this.typeLocale38DetailService.item;
    }
    set typeLocale38Detail(value: TypeLocale38DetailDto) {
        this.typeLocale38DetailService.item = value;
    }
    get typeLocale38Details(): Array<TypeLocale38DetailDto> {
        return this.typeLocale38DetailService.items;
    }
    set typeLocale38Details(value: Array<TypeLocale38DetailDto>) {
        this.typeLocale38DetailService.items = value;
    }
    get createTypeLocale38DetailDialog(): boolean {
        return this.typeLocale38DetailService.createDialog;
    }
    set createTypeLocale38DetailDialog(value: boolean) {
        this.typeLocale38DetailService.createDialog= value;
    }
    get categorieLocale(): CategorieLocaleDto {
        return this.categorieLocaleService.item;
    }
    set categorieLocale(value: CategorieLocaleDto) {
        this.categorieLocaleService.item = value;
    }
    get categorieLocales(): Array<CategorieLocaleDto> {
        return this.categorieLocaleService.items;
    }
    set categorieLocales(value: Array<CategorieLocaleDto>) {
        this.categorieLocaleService.items = value;
    }
    get createCategorieLocaleDialog(): boolean {
        return this.categorieLocaleService.createDialog;
    }
    set createCategorieLocaleDialog(value: boolean) {
        this.categorieLocaleService.createDialog= value;
    }



    get validTauxTaxe38Code(): boolean {
        return this._validTauxTaxe38Code;
    }

    set validTauxTaxe38Code(value: boolean) {
         this._validTauxTaxe38Code = value;
    }

    get validTypeLocale38DetailCode(): boolean {
        return this._validTypeLocale38DetailCode;
    }
    set validTypeLocale38DetailCode(value: boolean) {
        this._validTypeLocale38DetailCode = value;
    }
    get validTypeLocale38DetailLibelle(): boolean {
        return this._validTypeLocale38DetailLibelle;
    }
    set validTypeLocale38DetailLibelle(value: boolean) {
        this._validTypeLocale38DetailLibelle = value;
    }
    get validCategorieLocaleCode(): boolean {
        return this._validCategorieLocaleCode;
    }
    set validCategorieLocaleCode(value: boolean) {
        this._validCategorieLocaleCode = value;
    }
    get validCategorieLocaleLibelle(): boolean {
        return this._validCategorieLocaleLibelle;
    }
    set validCategorieLocaleLibelle(value: boolean) {
        this._validCategorieLocaleLibelle = value;
    }


    get items(): Array<TauxTaxe38Dto> {
        return this.service.items;
    }

    set items(value: Array<TauxTaxe38Dto>) {
        this.service.items = value;
    }

    get item(): TauxTaxe38Dto {
        return this.service.item;
    }

    set item(value: TauxTaxe38Dto) {
        this.service.item = value;
    }

    get createDialog(): boolean {
        return this.service.createDialog;
    }

    set createDialog(value: boolean) {
        this.service.createDialog = value;
    }

    get criteria(): TauxTaxe38Criteria {
        return this.service.criteria;
    }

    set criteria(value: TauxTaxe38Criteria) {
        this.service.criteria = value;
    }

    get dateFormat() {
        return environment.dateFormatCreate;
    }

    get dateFormatColumn() {
        return environment.dateFormatCreate;
    }

    get submitted(): boolean {
        return this._submitted;
    }

    set submitted(value: boolean) {
        this._submitted = value;
    }

    get errorMessages(): string[] {
        if (this._errorMessages == null) {
            this._errorMessages = new Array<string>();
        }
        return this._errorMessages;
    }

    set errorMessages(value: string[]) {
        this._errorMessages = value;
    }

    get validate(): boolean {
        return this.service.validate;
    }

    set validate(value: boolean) {
        this.service.validate = value;
    }


    get activeTab(): number {
        return this._activeTab;
    }

    set activeTab(value: number) {
        this._activeTab = value;
    }


}
