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



import {Locale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Locale38DetailAdmin.service';
import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailCriteria} from 'src/app/shared/criteria/taxe38/Locale38DetailCriteria.model';
import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
@Component({
  selector: 'app-locale38-detail-create-admin',
  templateUrl: './locale38-detail-create-admin.component.html'
})
export class Locale38DetailCreateAdminComponent  implements OnInit {

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



   private _validLocale38DetailCode = true;
    private _validTypeLocale38DetailCode = true;
    private _validTypeLocale38DetailLibelle = true;

	constructor(private service: Locale38DetailAdminService , private typeLocale38DetailService: TypeLocale38DetailAdminService, @Inject(PLATFORM_ID) private platformId? ) {
        this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
    }

    ngOnInit(): void {
        this.typeLocale38DetailService.findAll().subscribe((data) => this.typeLocale38Details = data);
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
                this.item = new Locale38DetailDto();
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
        this.validLocale38DetailCode = value;
    }



    public  validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateLocale38DetailCode();
    }

    public validateLocale38DetailCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validLocale38DetailCode = false;
        } else {
            this.validLocale38DetailCode = true;
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



    get validLocale38DetailCode(): boolean {
        return this._validLocale38DetailCode;
    }

    set validLocale38DetailCode(value: boolean) {
         this._validLocale38DetailCode = value;
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


    get items(): Array<Locale38DetailDto> {
        return this.service.items;
    }

    set items(value: Array<Locale38DetailDto>) {
        this.service.items = value;
    }

    get item(): Locale38DetailDto {
        return this.service.item;
    }

    set item(value: Locale38DetailDto) {
        this.service.item = value;
    }

    get createDialog(): boolean {
        return this.service.createDialog;
    }

    set createDialog(value: boolean) {
        this.service.createDialog = value;
    }

    get criteria(): Locale38DetailCriteria {
        return this.service.criteria;
    }

    set criteria(value: Locale38DetailCriteria) {
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
