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




import {NotificationRetardPremierNiveauAdminService} from 'src/app/shared/service/admin/NotificationPremierNiv/NotificationRetardPremierNiveauAdmin.service';
import {NotificationRetardPremierNiveauDto} from 'src/app/shared/model/NotificationPremierNiv/NotificationRetardPremierNiveau.model';
import {NotificationRetardPremierNiveauCriteria} from 'src/app/shared/criteria/NotificationPremierNiv/NotificationRetardPremierNiveauCriteria.model';


import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';

@Component({
  selector: 'app-notification-retard-premier-niveau-edit-admin',
  templateUrl: './notification-retard-premier-niveau-edit-admin.component.html'
})
export class NotificationRetardPremierNiveauEditAdminComponent implements OnInit {

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



    private _validNotificationRetardPremierNiveauCode = true;

    private _validLocaleCode = true;
    private _validRedevableCin = true;



    constructor(private service: NotificationRetardPremierNiveauAdminService , private localeService: LocaleAdminService, private redevableService: RedevableAdminService, @Inject(PLATFORM_ID) private platformId?) {
        this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
    }

    ngOnInit(): void {
        this.localeService.findAll().subscribe((data) => this.locales = data);
        this.redevableService.findAll().subscribe((data) => this.redevables = data);
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
            this.item = new NotificationRetardPremierNiveauDto();
        } , error =>{
            console.log(error);
        });
    }



    public hideEditDialog() {
        this.editDialog = false;
        this.setValidation(true);
    }





    public setValidation(value: boolean){
        this.validNotificationRetardPremierNiveauCode = value;
    }

    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateNotificationRetardPremierNiveauCode();
    }

    public validateNotificationRetardPremierNiveauCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validNotificationRetardPremierNiveauCode = false;
        } else {
            this.validNotificationRetardPremierNiveauCode = true;
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


    get validNotificationRetardPremierNiveauCode(): boolean {
        return this._validNotificationRetardPremierNiveauCode;
    }
    set validNotificationRetardPremierNiveauCode(value: boolean) {
        this._validNotificationRetardPremierNiveauCode = value;
    }

    get validLocaleCode(): boolean {
        return this._validLocaleCode;
    }
    set validLocaleCode(value: boolean) {
        this._validLocaleCode = value;
    }
    get validRedevableCin(): boolean {
        return this._validRedevableCin;
    }
    set validRedevableCin(value: boolean) {
        this._validRedevableCin = value;
    }

	get items(): Array<NotificationRetardPremierNiveauDto> {
        return this.service.items;
    }

    set items(value: Array<NotificationRetardPremierNiveauDto>) {
        this.service.items = value;
    }

    get item(): NotificationRetardPremierNiveauDto {
        return this.service.item;
    }

    set item(value: NotificationRetardPremierNiveauDto) {
        this.service.item = value;
    }

    get editDialog(): boolean {
        return this.service.editDialog;
    }

    set editDialog(value: boolean) {
        this.service.editDialog = value;
    }

    get criteria(): NotificationRetardPremierNiveauCriteria {
        return this.service.criteria;
    }

    set criteria(value: NotificationRetardPremierNiveauCriteria) {
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
