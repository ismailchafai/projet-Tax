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




import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailCriteria} from 'src/app/shared/criteria/taxe38/TypeLocale38DetailCriteria.model';



@Component({
  selector: 'app-type-locale38-detail-edit-admin',
  templateUrl: './type-locale38-detail-edit-admin.component.html'
})
export class TypeLocale38DetailEditAdminComponent implements OnInit {

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



    private _validTypeLocale38DetailCode = true;
    private _validTypeLocale38DetailLibelle = true;




    constructor(private service: TypeLocale38DetailAdminService , @Inject(PLATFORM_ID) private platformId?) {
        this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
    }

    ngOnInit(): void {
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
            this.item = new TypeLocale38DetailDto();
        } , error =>{
            console.log(error);
        });
    }



    public hideEditDialog() {
        this.editDialog = false;
        this.setValidation(true);
    }





    public setValidation(value: boolean){
        this.validTypeLocale38DetailCode = value;
        this.validTypeLocale38DetailLibelle = value;
    }

    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTypeLocale38DetailCode();
        this.validateTypeLocale38DetailLibelle();
    }

    public validateTypeLocale38DetailCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validTypeLocale38DetailCode = false;
        } else {
            this.validTypeLocale38DetailCode = true;
        }
    }

    public validateTypeLocale38DetailLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validTypeLocale38DetailLibelle = false;
        } else {
            this.validTypeLocale38DetailLibelle = true;
        }
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


	get items(): Array<TypeLocale38DetailDto> {
        return this.service.items;
    }

    set items(value: Array<TypeLocale38DetailDto>) {
        this.service.items = value;
    }

    get item(): TypeLocale38DetailDto {
        return this.service.item;
    }

    set item(value: TypeLocale38DetailDto) {
        this.service.item = value;
    }

    get editDialog(): boolean {
        return this.service.editDialog;
    }

    set editDialog(value: boolean) {
        this.service.editDialog = value;
    }

    get criteria(): TypeLocale38DetailCriteria {
        return this.service.criteria;
    }

    set criteria(value: TypeLocale38DetailCriteria) {
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
