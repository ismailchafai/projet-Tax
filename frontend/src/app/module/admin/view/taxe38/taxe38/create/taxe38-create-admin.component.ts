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



import {Taxe38AdminService} from 'src/app/shared/service/admin/taxe38/Taxe38Admin.service';
import {Taxe38Dto} from 'src/app/shared/model/taxe38/Taxe38.model';
import {Taxe38Criteria} from 'src/app/shared/criteria/taxe38/Taxe38Criteria.model';
import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';
import {Taxe38DetailDto} from 'src/app/shared/model/taxe38/Taxe38Detail.model';
import {Taxe38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Taxe38DetailAdmin.service';
import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Locale38DetailAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';
@Component({
  selector: 'app-taxe38-create-admin',
  templateUrl: './taxe38-create-admin.component.html'
})
export class Taxe38CreateAdminComponent  implements OnInit {

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

    private _taxe38DetailsElement = new Taxe38DetailDto();


   private _validTaxe38Code = true;
    private _validRedevableCin = true;
    private _validLocaleCode = true;
    private _validTrimLibelle = true;
    private _validTaxe38DetailsCode = true;

	constructor(private service: Taxe38AdminService , private localeService: LocaleAdminService, private trimService: TrimAdminService, private taxe38DetailService: Taxe38DetailAdminService, private locale38DetailService: Locale38DetailAdminService, private redevableService: RedevableAdminService, private tauxTaxe38Service: TauxTaxe38AdminService, @Inject(PLATFORM_ID) private platformId? ) {
        this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
    }

    ngOnInit(): void {
        this.taxe38DetailsElement.locale38Detail = new Locale38DetailDto();
        this.locale38DetailService.findAll().subscribe((data) => this.locale38Details = data);
        this.taxe38DetailsElement.tauxTaxe38 = new TauxTaxe38Dto();
        this.tauxTaxe38Service.findAll().subscribe((data) => this.tauxTaxe38s = data);
        this.redevableService.findAll().subscribe((data) => this.redevables = data);
        this.localeService.findAll().subscribe((data) => this.locales = data);
        this.trimService.findAll().subscribe((data) => this.trims = data);
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
                this.item = new Taxe38Dto();
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



    validateTaxe38Details(){
        this.errorMessages = new Array();
        this.validateTaxe38DetailsCode();
    }


    public  setValidation(value: boolean){
        this.validTaxe38Code = value;
        this.validTaxe38DetailsCode = value;
    }

    public addTaxe38Details() {
        if( this.item.taxe38Details == null )
            this.item.taxe38Details = new Array<Taxe38DetailDto>();
       this.validateTaxe38Details();
       if (this.errorMessages.length === 0) {
              this.item.taxe38Details.push({... this.taxe38DetailsElement});
              this.taxe38DetailsElement = new Taxe38DetailDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletetaxe38Details(p: Taxe38DetailDto) {
        this.item.taxe38Details.forEach((element, index) => {
            if (element === p) { this.item.taxe38Details.splice(index, 1); }
        });
    }

    public edittaxe38Details(p: Taxe38DetailDto) {
        this.taxe38DetailsElement = {... p};
        this.activeTab = 0;
    }


    public  validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTaxe38Code();
    }

    public validateTaxe38Code(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validTaxe38Code = false;
        } else {
            this.validTaxe38Code = true;
        }
    }

    public validateTaxe38DetailsCode(){
        if (this.taxe38DetailsElement.code == null) {
            this.errorMessages.push('Code de la taxe38Detail est  invalide');
            this.validTaxe38DetailsCode = false;
        } else {
            this.validTaxe38DetailsCode = true;
        }
    }

    public async openCreateLocale38Detail(locale38Detail: string) {
    const isPermistted = await this.roleService.isPermitted('Locale38Detail', 'add');
    if(isPermistted) {
         this.locale38Detail = new Locale38DetailDto();
         this.createLocale38DetailDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateTauxTaxe38(tauxTaxe38: string) {
    const isPermistted = await this.roleService.isPermitted('TauxTaxe38', 'add');
    if(isPermistted) {
         this.tauxTaxe38 = new TauxTaxe38Dto();
         this.createTauxTaxe38Dialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateTrim(trim: string) {
    const isPermistted = await this.roleService.isPermitted('Trim', 'add');
    if(isPermistted) {
         this.trim = new TrimDto();
         this.createTrimDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get locale(): LocaleDto {
        return this.localeService.item;
    }
    set locale(value: LocaleDto) {
        this.localeService.item = value;
    }
    get locales(): Array<LocaleDto> {
        return this.localeService.items;
    }
    set locales(value: Array<LocaleDto>) {
        this.localeService.items = value;
    }
    get createLocaleDialog(): boolean {
        return this.localeService.createDialog;
    }
    set createLocaleDialog(value: boolean) {
        this.localeService.createDialog= value;
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
    get redevable(): RedevableDto {
        return this.redevableService.item;
    }
    set redevable(value: RedevableDto) {
        this.redevableService.item = value;
    }
    get redevables(): Array<RedevableDto> {
        return this.redevableService.items;
    }
    set redevables(value: Array<RedevableDto>) {
        this.redevableService.items = value;
    }
    get createRedevableDialog(): boolean {
        return this.redevableService.createDialog;
    }
    set createRedevableDialog(value: boolean) {
        this.redevableService.createDialog= value;
    }
    get trim(): TrimDto {
        return this.trimService.item;
    }
    set trim(value: TrimDto) {
        this.trimService.item = value;
    }
    get trims(): Array<TrimDto> {
        return this.trimService.items;
    }
    set trims(value: Array<TrimDto>) {
        this.trimService.items = value;
    }
    get createTrimDialog(): boolean {
        return this.trimService.createDialog;
    }
    set createTrimDialog(value: boolean) {
        this.trimService.createDialog= value;
    }



    get validTaxe38Code(): boolean {
        return this._validTaxe38Code;
    }

    set validTaxe38Code(value: boolean) {
         this._validTaxe38Code = value;
    }

    get validRedevableCin(): boolean {
        return this._validRedevableCin;
    }
    set validRedevableCin(value: boolean) {
        this._validRedevableCin = value;
    }
    get validLocaleCode(): boolean {
        return this._validLocaleCode;
    }
    set validLocaleCode(value: boolean) {
        this._validLocaleCode = value;
    }
    get validTrimLibelle(): boolean {
        return this._validTrimLibelle;
    }
    set validTrimLibelle(value: boolean) {
        this._validTrimLibelle = value;
    }
    get validTaxe38DetailsCode(): boolean {
        return this._validTaxe38DetailsCode;
    }
    set validTaxe38DetailsCode(value: boolean) {
        this._validTaxe38DetailsCode = value;
    }

    get taxe38DetailsElement(): Taxe38DetailDto {
        if( this._taxe38DetailsElement == null )
            this._taxe38DetailsElement = new Taxe38DetailDto();
        return this._taxe38DetailsElement;
    }

    set taxe38DetailsElement(value: Taxe38DetailDto) {
        this._taxe38DetailsElement = value;
    }

    get items(): Array<Taxe38Dto> {
        return this.service.items;
    }

    set items(value: Array<Taxe38Dto>) {
        this.service.items = value;
    }

    get item(): Taxe38Dto {
        return this.service.item;
    }

    set item(value: Taxe38Dto) {
        this.service.item = value;
    }

    get createDialog(): boolean {
        return this.service.createDialog;
    }

    set createDialog(value: boolean) {
        this.service.createDialog = value;
    }

    get criteria(): Taxe38Criteria {
        return this.service.criteria;
    }

    set criteria(value: Taxe38Criteria) {
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
