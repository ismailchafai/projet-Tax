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



import {NotificationRetardTroisiemeNiveauAdminService} from 'src/app/shared/service/admin/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiveauAdmin.service';
import {NotificationRetardTroisiemeNiveauDto} from 'src/app/shared/model/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiveau.model';
import {NotificationRetardTroisiemeNiveauCriteria} from 'src/app/shared/criteria/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiveauCriteria.model';
import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';
@Component({
  selector: 'app-notification-retard-troisieme-niveau-create-admin',
  templateUrl: './notification-retard-troisieme-niveau-create-admin.component.html'
})
export class NotificationRetardTroisiemeNiveauCreateAdminComponent  implements OnInit {

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



   private _validNotificationRetardTroisiemeNiveauCode = true;
    private _validLocaleCode = true;
    private _validRedevableCin = true;
    private _validTrimLibelle = true;

	constructor(private service: NotificationRetardTroisiemeNiveauAdminService , private localeService: LocaleAdminService, private trimService: TrimAdminService, private redevableService: RedevableAdminService, @Inject(PLATFORM_ID) private platformId? ) {
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
                this.item = new NotificationRetardTroisiemeNiveauDto();
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
        this.validNotificationRetardTroisiemeNiveauCode = value;
    }



    public  validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateNotificationRetardTroisiemeNiveauCode();
    }

    public validateNotificationRetardTroisiemeNiveauCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validNotificationRetardTroisiemeNiveauCode = false;
        } else {
            this.validNotificationRetardTroisiemeNiveauCode = true;
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



    get validNotificationRetardTroisiemeNiveauCode(): boolean {
        return this._validNotificationRetardTroisiemeNiveauCode;
    }

    set validNotificationRetardTroisiemeNiveauCode(value: boolean) {
         this._validNotificationRetardTroisiemeNiveauCode = value;
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
    get validTrimLibelle(): boolean {
        return this._validTrimLibelle;
    }
    set validTrimLibelle(value: boolean) {
        this._validTrimLibelle = value;
    }


    get items(): Array<NotificationRetardTroisiemeNiveauDto> {
        return this.service.items;
    }

    set items(value: Array<NotificationRetardTroisiemeNiveauDto>) {
        this.service.items = value;
    }

    get item(): NotificationRetardTroisiemeNiveauDto {
        return this.service.item;
    }

    set item(value: NotificationRetardTroisiemeNiveauDto) {
        this.service.item = value;
    }

    get createDialog(): boolean {
        return this.service.createDialog;
    }

    set createDialog(value: boolean) {
        this.service.createDialog = value;
    }

    get criteria(): NotificationRetardTroisiemeNiveauCriteria {
        return this.service.criteria;
    }

    set criteria(value: NotificationRetardTroisiemeNiveauCriteria) {
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
