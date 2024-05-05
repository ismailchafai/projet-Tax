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



import {NotificationRetardDeuxiemeNiveauAdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauAdmin.service';
import {NotificationRetardDeuxiemeNiveauDto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveau.model';
import {NotificationRetardDeuxiemeNiveauCriteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauCriteria.model';
import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';
@Component({
  selector: 'app-notification-retard-deuxieme-niveau-create-admin',
  templateUrl: './notification-retard-deuxieme-niveau-create-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauCreateAdminComponent  implements OnInit {

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



   private _validNotificationRetardDeuxiemeNiveauCode = true;
    private _validLocaleCode = true;
    private _validRedevableCin = true;

	constructor(private service: NotificationRetardDeuxiemeNiveauAdminService , private localeService: LocaleAdminService, private redevableService: RedevableAdminService, @Inject(PLATFORM_ID) private platformId? ) {
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
                this.item = new NotificationRetardDeuxiemeNiveauDto();
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
        this.validNotificationRetardDeuxiemeNiveauCode = value;
    }



    public  validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateNotificationRetardDeuxiemeNiveauCode();
    }

    public validateNotificationRetardDeuxiemeNiveauCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validNotificationRetardDeuxiemeNiveauCode = false;
        } else {
            this.validNotificationRetardDeuxiemeNiveauCode = true;
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



    get validNotificationRetardDeuxiemeNiveauCode(): boolean {
        return this._validNotificationRetardDeuxiemeNiveauCode;
    }

    set validNotificationRetardDeuxiemeNiveauCode(value: boolean) {
         this._validNotificationRetardDeuxiemeNiveauCode = value;
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


    get items(): Array<NotificationRetardDeuxiemeNiveauDto> {
        return this.service.items;
    }

    set items(value: Array<NotificationRetardDeuxiemeNiveauDto>) {
        this.service.items = value;
    }

    get item(): NotificationRetardDeuxiemeNiveauDto {
        return this.service.item;
    }

    set item(value: NotificationRetardDeuxiemeNiveauDto) {
        this.service.item = value;
    }

    get createDialog(): boolean {
        return this.service.createDialog;
    }

    set createDialog(value: boolean) {
        this.service.createDialog = value;
    }

    get criteria(): NotificationRetardDeuxiemeNiveauCriteria {
        return this.service.criteria;
    }

    set criteria(value: NotificationRetardDeuxiemeNiveauCriteria) {
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
