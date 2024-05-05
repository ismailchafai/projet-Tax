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




import {NotificationRetardDeuxiemeNiveauDetailType38AdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38Admin.service';
import {NotificationRetardDeuxiemeNiveauDetailType38Dto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38.model';
import {NotificationRetardDeuxiemeNiveauDetailType38Criteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38Criteria.model';


import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';

@Component({
  selector: 'app-notification-retard-deuxieme-niveau-detail-type38-edit-admin',
  templateUrl: './notification-retard-deuxieme-niveau-detail-type38-edit-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauDetailType38EditAdminComponent implements OnInit {

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



    private _validNotificationRetardDeuxiemeNiveauDetailType38Code = true;

    private _validTypeLocale38Code = true;
    private _validTypeLocale38Libelle = true;



    constructor(private service: NotificationRetardDeuxiemeNiveauDetailType38AdminService , private typeLocale38DetailService: TypeLocale38DetailAdminService, @Inject(PLATFORM_ID) private platformId?) {
        this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
    }

    ngOnInit(): void {
        this.typeLocale38DetailService.findAll().subscribe((data) => this.typeLocale38s = data);
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
            this.item = new NotificationRetardDeuxiemeNiveauDetailType38Dto();
        } , error =>{
            console.log(error);
        });
    }



    public hideEditDialog() {
        this.editDialog = false;
        this.setValidation(true);
    }





    public setValidation(value: boolean){
        this.validNotificationRetardDeuxiemeNiveauDetailType38Code = value;
    }

    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateNotificationRetardDeuxiemeNiveauDetailType38Code();
    }

    public validateNotificationRetardDeuxiemeNiveauDetailType38Code(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validNotificationRetardDeuxiemeNiveauDetailType38Code = false;
        } else {
            this.validNotificationRetardDeuxiemeNiveauDetailType38Code = true;
        }
    }





    get typeLocale38(): TypeLocale38DetailDto {
        return this.typeLocale38DetailService.item;
    }
    set typeLocale38(value: TypeLocale38DetailDto) {
        this.typeLocale38DetailService.item = value;
    }
    get typeLocale38s(): Array<TypeLocale38DetailDto> {
        return this.typeLocale38DetailService.items;
    }
    set typeLocale38s(value: Array<TypeLocale38DetailDto>) {
        this.typeLocale38DetailService.items = value;
    }
    get createTypeLocale38Dialog(): boolean {
        return this.typeLocale38DetailService.createDialog;
    }
    set createTypeLocale38Dialog(value: boolean) {
        this.typeLocale38DetailService.createDialog= value;
    }


    get validNotificationRetardDeuxiemeNiveauDetailType38Code(): boolean {
        return this._validNotificationRetardDeuxiemeNiveauDetailType38Code;
    }
    set validNotificationRetardDeuxiemeNiveauDetailType38Code(value: boolean) {
        this._validNotificationRetardDeuxiemeNiveauDetailType38Code = value;
    }

    get validTypeLocale38Code(): boolean {
        return this._validTypeLocale38Code;
    }
    set validTypeLocale38Code(value: boolean) {
        this._validTypeLocale38Code = value;
    }
    get validTypeLocale38Libelle(): boolean {
        return this._validTypeLocale38Libelle;
    }
    set validTypeLocale38Libelle(value: boolean) {
        this._validTypeLocale38Libelle = value;
    }

	get items(): Array<NotificationRetardDeuxiemeNiveauDetailType38Dto> {
        return this.service.items;
    }

    set items(value: Array<NotificationRetardDeuxiemeNiveauDetailType38Dto>) {
        this.service.items = value;
    }

    get item(): NotificationRetardDeuxiemeNiveauDetailType38Dto {
        return this.service.item;
    }

    set item(value: NotificationRetardDeuxiemeNiveauDetailType38Dto) {
        this.service.item = value;
    }

    get editDialog(): boolean {
        return this.service.editDialog;
    }

    set editDialog(value: boolean) {
        this.service.editDialog = value;
    }

    get criteria(): NotificationRetardDeuxiemeNiveauDetailType38Criteria {
        return this.service.criteria;
    }

    set criteria(value: NotificationRetardDeuxiemeNiveauDetailType38Criteria) {
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
