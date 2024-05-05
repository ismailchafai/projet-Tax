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




import {Taxe38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Taxe38DetailAdmin.service';
import {Taxe38DetailDto} from 'src/app/shared/model/taxe38/Taxe38Detail.model';
import {Taxe38DetailCriteria} from 'src/app/shared/criteria/taxe38/Taxe38DetailCriteria.model';


import {Taxe38Dto} from 'src/app/shared/model/taxe38/Taxe38.model';
import {Taxe38AdminService} from 'src/app/shared/service/admin/taxe38/Taxe38Admin.service';
import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Locale38DetailAdmin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';

@Component({
  selector: 'app-taxe38-detail-edit-admin',
  templateUrl: './taxe38-detail-edit-admin.component.html'
})
export class Taxe38DetailEditAdminComponent implements OnInit {

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



    private _validTaxe38DetailCode = true;

    private _validLocale38DetailCode = true;
    private _validTauxTaxe38Code = true;
    private _validTaxe38Code = true;



    constructor(private service: Taxe38DetailAdminService , private taxe38Service: Taxe38AdminService, private locale38DetailService: Locale38DetailAdminService, private tauxTaxe38Service: TauxTaxe38AdminService, @Inject(PLATFORM_ID) private platformId?) {
        this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
    }

    ngOnInit(): void {
        this.locale38DetailService.findAll().subscribe((data) => this.locale38Details = data);
        this.tauxTaxe38Service.findAll().subscribe((data) => this.tauxTaxe38s = data);
        this.taxe38Service.findAll().subscribe((data) => this.taxe38s = data);
    }

    public prepareEdit() {
    }



 public edit(): void {
        this.submitted = true;
        this.prepareEdit();
        this.validateForm();
        if (this.errorMessages.length === 0) {
            this.editWithShowOption(false);
        } else {
            this.messageService.add({
                severity: 'error',
                summary: 'Erreurs',
                detail: 'Merci de corrigé les erreurs sur le formulaire'
            });
        }
    }

    public editWithShowOption(showList: boolean) {
        this.service.edit().subscribe(religion=>{
            const myIndex = this.items.findIndex(e => e.id === this.item.id);
            this.items[myIndex] = religion;
            this.editDialog = false;
            this.submitted = false;
            this.item = new Taxe38DetailDto();
        } , error =>{
            console.log(error);
        });
    }



    public hideEditDialog() {
        this.editDialog = false;
        this.setValidation(true);
    }





    public setValidation(value: boolean){
        this.validTaxe38DetailCode = value;
    }

    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTaxe38DetailCode();
    }

    public validateTaxe38DetailCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validTaxe38DetailCode = false;
        } else {
            this.validTaxe38DetailCode = true;
        }
    }




   public async openCreateLocale38Detail(locale38Detail: string) {
        const isPermistted = await this.roleService.isPermitted('Locale38Detail', 'edit');
        if (isPermistted) {
             this.locale38Detail = new Locale38DetailDto();
             this.createLocale38DetailDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateTauxTaxe38(tauxTaxe38: string) {
        const isPermistted = await this.roleService.isPermitted('TauxTaxe38', 'edit');
        if (isPermistted) {
             this.tauxTaxe38 = new TauxTaxe38Dto();
             this.createTauxTaxe38Dialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateTaxe38(taxe38: string) {
        const isPermistted = await this.roleService.isPermitted('Taxe38', 'edit');
        if (isPermistted) {
             this.taxe38 = new Taxe38Dto();
             this.createTaxe38Dialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

    get locale38Detail(): Locale38DetailDto {
        return this.locale38DetailService.item;
    }
    set locale38Detail(value: Locale38DetailDto) {
        this.locale38DetailService.item = value;
    }
    get locale38Details(): Array<Locale38DetailDto> {
        return this.locale38DetailService.items;
    }
    set locale38Details(value: Array<Locale38DetailDto>) {
        this.locale38DetailService.items = value;
    }
    get createLocale38DetailDialog(): boolean {
        return this.locale38DetailService.createDialog;
    }
    set createLocale38DetailDialog(value: boolean) {
        this.locale38DetailService.createDialog= value;
    }
    get tauxTaxe38(): TauxTaxe38Dto {
        return this.tauxTaxe38Service.item;
    }
    set tauxTaxe38(value: TauxTaxe38Dto) {
        this.tauxTaxe38Service.item = value;
    }
    get tauxTaxe38s(): Array<TauxTaxe38Dto> {
        return this.tauxTaxe38Service.items;
    }
    set tauxTaxe38s(value: Array<TauxTaxe38Dto>) {
        this.tauxTaxe38Service.items = value;
    }
    get createTauxTaxe38Dialog(): boolean {
        return this.tauxTaxe38Service.createDialog;
    }
    set createTauxTaxe38Dialog(value: boolean) {
        this.tauxTaxe38Service.createDialog= value;
    }
    get taxe38(): Taxe38Dto {
        return this.taxe38Service.item;
    }
    set taxe38(value: Taxe38Dto) {
        this.taxe38Service.item = value;
    }
    get taxe38s(): Array<Taxe38Dto> {
        return this.taxe38Service.items;
    }
    set taxe38s(value: Array<Taxe38Dto>) {
        this.taxe38Service.items = value;
    }
    get createTaxe38Dialog(): boolean {
        return this.taxe38Service.createDialog;
    }
    set createTaxe38Dialog(value: boolean) {
        this.taxe38Service.createDialog= value;
    }


    get validTaxe38DetailCode(): boolean {
        return this._validTaxe38DetailCode;
    }
    set validTaxe38DetailCode(value: boolean) {
        this._validTaxe38DetailCode = value;
    }

    get validLocale38DetailCode(): boolean {
        return this._validLocale38DetailCode;
    }
    set validLocale38DetailCode(value: boolean) {
        this._validLocale38DetailCode = value;
    }
    get validTauxTaxe38Code(): boolean {
        return this._validTauxTaxe38Code;
    }
    set validTauxTaxe38Code(value: boolean) {
        this._validTauxTaxe38Code = value;
    }
    get validTaxe38Code(): boolean {
        return this._validTaxe38Code;
    }
    set validTaxe38Code(value: boolean) {
        this._validTaxe38Code = value;
    }

	get items(): Array<Taxe38DetailDto> {
        return this.service.items;
    }

    set items(value: Array<Taxe38DetailDto>) {
        this.service.items = value;
    }

    get item(): Taxe38DetailDto {
        return this.service.item;
    }

    set item(value: Taxe38DetailDto) {
        this.service.item = value;
    }

    get editDialog(): boolean {
        return this.service.editDialog;
    }

    set editDialog(value: boolean) {
        this.service.editDialog = value;
    }

    get criteria(): Taxe38DetailCriteria {
        return this.service.criteria;
    }

    set criteria(value: Taxe38DetailCriteria) {
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
