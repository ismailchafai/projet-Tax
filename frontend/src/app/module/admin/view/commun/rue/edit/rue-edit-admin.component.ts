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




import {RueAdminService} from 'src/app/shared/service/admin/commun/RueAdmin.service';
import {RueDto} from 'src/app/shared/model/commun/Rue.model';
import {RueCriteria} from 'src/app/shared/criteria/commun/RueCriteria.model';


import {QuartierDto} from 'src/app/shared/model/commun/Quartier.model';
import {QuartierAdminService} from 'src/app/shared/service/admin/commun/QuartierAdmin.service';

@Component({
  selector: 'app-rue-edit-admin',
  templateUrl: './rue-edit-admin.component.html'
})
export class RueEditAdminComponent implements OnInit {

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



    private _validRueCode = true;
    private _validRueLibelle = true;

    private _validQuartierCode = true;
    private _validQuartierLibelle = true;



    constructor(private service: RueAdminService , private quartierService: QuartierAdminService, @Inject(PLATFORM_ID) private platformId?) {
        this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
    }

    ngOnInit(): void {
        this.quartierService.findAll().subscribe((data) => this.quartiers = data);
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
            this.item = new RueDto();
        } , error =>{
            console.log(error);
        });
    }



    public hideEditDialog() {
        this.editDialog = false;
        this.setValidation(true);
    }





    public setValidation(value: boolean){
        this.validRueCode = value;
        this.validRueLibelle = value;
    }

    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateRueCode();
        this.validateRueLibelle();
    }

    public validateRueCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validRueCode = false;
        } else {
            this.validRueCode = true;
        }
    }

    public validateRueLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validRueLibelle = false;
        } else {
            this.validRueLibelle = true;
        }
    }




   public async openCreateQuartier(quartier: string) {
        const isPermistted = await this.roleService.isPermitted('Quartier', 'edit');
        if (isPermistted) {
             this.quartier = new QuartierDto();
             this.createQuartierDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

    get quartier(): QuartierDto {
        return this.quartierService.item;
    }
    set quartier(value: QuartierDto) {
        this.quartierService.item = value;
    }
    get quartiers(): Array<QuartierDto> {
        return this.quartierService.items;
    }
    set quartiers(value: Array<QuartierDto>) {
        this.quartierService.items = value;
    }
    get createQuartierDialog(): boolean {
        return this.quartierService.createDialog;
    }
    set createQuartierDialog(value: boolean) {
        this.quartierService.createDialog= value;
    }


    get validRueCode(): boolean {
        return this._validRueCode;
    }
    set validRueCode(value: boolean) {
        this._validRueCode = value;
    }
    get validRueLibelle(): boolean {
        return this._validRueLibelle;
    }
    set validRueLibelle(value: boolean) {
        this._validRueLibelle = value;
    }

    get validQuartierCode(): boolean {
        return this._validQuartierCode;
    }
    set validQuartierCode(value: boolean) {
        this._validQuartierCode = value;
    }
    get validQuartierLibelle(): boolean {
        return this._validQuartierLibelle;
    }
    set validQuartierLibelle(value: boolean) {
        this._validQuartierLibelle = value;
    }

	get items(): Array<RueDto> {
        return this.service.items;
    }

    set items(value: Array<RueDto>) {
        this.service.items = value;
    }

    get item(): RueDto {
        return this.service.item;
    }

    set item(value: RueDto) {
        this.service.item = value;
    }

    get editDialog(): boolean {
        return this.service.editDialog;
    }

    set editDialog(value: boolean) {
        this.service.editDialog = value;
    }

    get criteria(): RueCriteria {
        return this.service.criteria;
    }

    set criteria(value: RueCriteria) {
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
