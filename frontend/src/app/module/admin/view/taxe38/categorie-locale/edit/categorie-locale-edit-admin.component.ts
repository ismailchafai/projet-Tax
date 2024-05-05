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




import {CategorieLocaleAdminService} from 'src/app/shared/service/admin/taxe38/CategorieLocaleAdmin.service';
import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleCriteria} from 'src/app/shared/criteria/taxe38/CategorieLocaleCriteria.model';



@Component({
  selector: 'app-categorie-locale-edit-admin',
  templateUrl: './categorie-locale-edit-admin.component.html'
})
export class CategorieLocaleEditAdminComponent implements OnInit {

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



    private _validCategorieLocaleCode = true;
    private _validCategorieLocaleLibelle = true;




    constructor(private service: CategorieLocaleAdminService , @Inject(PLATFORM_ID) private platformId?) {
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
            this.item = new CategorieLocaleDto();
        } , error =>{
            console.log(error);
        });
    }



    public hideEditDialog() {
        this.editDialog = false;
        this.setValidation(true);
    }





    public setValidation(value: boolean){
        this.validCategorieLocaleCode = value;
        this.validCategorieLocaleLibelle = value;
    }

    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCategorieLocaleCode();
        this.validateCategorieLocaleLibelle();
    }

    public validateCategorieLocaleCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validCategorieLocaleCode = false;
        } else {
            this.validCategorieLocaleCode = true;
        }
    }

    public validateCategorieLocaleLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validCategorieLocaleLibelle = false;
        } else {
            this.validCategorieLocaleLibelle = true;
        }
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


	get items(): Array<CategorieLocaleDto> {
        return this.service.items;
    }

    set items(value: Array<CategorieLocaleDto>) {
        this.service.items = value;
    }

    get item(): CategorieLocaleDto {
        return this.service.item;
    }

    set item(value: CategorieLocaleDto) {
        this.service.item = value;
    }

    get editDialog(): boolean {
        return this.service.editDialog;
    }

    set editDialog(value: boolean) {
        this.service.editDialog = value;
    }

    get criteria(): CategorieLocaleCriteria {
        return this.service.criteria;
    }

    set criteria(value: CategorieLocaleCriteria) {
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
