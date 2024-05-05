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



import {QuartierAdminService} from 'src/app/shared/service/admin/commun/QuartierAdmin.service';
import {QuartierDto} from 'src/app/shared/model/commun/Quartier.model';
import {QuartierCriteria} from 'src/app/shared/criteria/commun/QuartierCriteria.model';
import {SecteurDto} from 'src/app/shared/model/commun/Secteur.model';
import {SecteurAdminService} from 'src/app/shared/service/admin/commun/SecteurAdmin.service';
@Component({
  selector: 'app-quartier-create-admin',
  templateUrl: './quartier-create-admin.component.html'
})
export class QuartierCreateAdminComponent  implements OnInit {

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



   private _validQuartierCode = true;
   private _validQuartierLibelle = true;
    private _validSecteurCode = true;
    private _validSecteurLibelle = true;

	constructor(private service: QuartierAdminService , private secteurService: SecteurAdminService, @Inject(PLATFORM_ID) private platformId? ) {
        this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
    }

    ngOnInit(): void {
        this.secteurService.findAll().subscribe((data) => this.secteurs = data);
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
                this.item = new QuartierDto();
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
        this.validQuartierCode = value;
        this.validQuartierLibelle = value;
    }



    public  validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateQuartierCode();
        this.validateQuartierLibelle();
    }

    public validateQuartierCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validQuartierCode = false;
        } else {
            this.validQuartierCode = true;
        }
    }
    public validateQuartierLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validQuartierLibelle = false;
        } else {
            this.validQuartierLibelle = true;
        }
    }


    public async openCreateSecteur(secteur: string) {
    const isPermistted = await this.roleService.isPermitted('Secteur', 'add');
    if(isPermistted) {
         this.secteur = new SecteurDto();
         this.createSecteurDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get secteur(): SecteurDto {
        return this.secteurService.item;
    }
    set secteur(value: SecteurDto) {
        this.secteurService.item = value;
    }
    get secteurs(): Array<SecteurDto> {
        return this.secteurService.items;
    }
    set secteurs(value: Array<SecteurDto>) {
        this.secteurService.items = value;
    }
    get createSecteurDialog(): boolean {
        return this.secteurService.createDialog;
    }
    set createSecteurDialog(value: boolean) {
        this.secteurService.createDialog= value;
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

    get validSecteurCode(): boolean {
        return this._validSecteurCode;
    }
    set validSecteurCode(value: boolean) {
        this._validSecteurCode = value;
    }
    get validSecteurLibelle(): boolean {
        return this._validSecteurLibelle;
    }
    set validSecteurLibelle(value: boolean) {
        this._validSecteurLibelle = value;
    }


    get items(): Array<QuartierDto> {
        return this.service.items;
    }

    set items(value: Array<QuartierDto>) {
        this.service.items = value;
    }

    get item(): QuartierDto {
        return this.service.item;
    }

    set item(value: QuartierDto) {
        this.service.item = value;
    }

    get createDialog(): boolean {
        return this.service.createDialog;
    }

    set createDialog(value: boolean) {
        this.service.createDialog = value;
    }

    get criteria(): QuartierCriteria {
        return this.service.criteria;
    }

    set criteria(value: QuartierCriteria) {
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
