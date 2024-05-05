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




import {SecteurAdminService} from 'src/app/shared/service/admin/commun/SecteurAdmin.service';
import {SecteurDto} from 'src/app/shared/model/commun/Secteur.model';
import {SecteurCriteria} from 'src/app/shared/criteria/commun/SecteurCriteria.model';


import {VilleDto} from 'src/app/shared/model/commun/Ville.model';
import {VilleAdminService} from 'src/app/shared/service/admin/commun/VilleAdmin.service';

@Component({
  selector: 'app-secteur-edit-admin',
  templateUrl: './secteur-edit-admin.component.html'
})
export class SecteurEditAdminComponent implements OnInit {

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



    private _validSecteurCode = true;
    private _validSecteurLibelle = true;

    private _validVilleCode = true;
    private _validVilleLibelle = true;



    constructor(private service: SecteurAdminService , private villeService: VilleAdminService, @Inject(PLATFORM_ID) private platformId?) {
        this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
    }

    ngOnInit(): void {
        this.villeService.findAll().subscribe((data) => this.villes = data);
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
            this.item = new SecteurDto();
        } , error =>{
            console.log(error);
        });
    }



    public hideEditDialog() {
        this.editDialog = false;
        this.setValidation(true);
    }





    public setValidation(value: boolean){
        this.validSecteurCode = value;
        this.validSecteurLibelle = value;
    }

    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSecteurCode();
        this.validateSecteurLibelle();
    }

    public validateSecteurCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validSecteurCode = false;
        } else {
            this.validSecteurCode = true;
        }
    }

    public validateSecteurLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validSecteurLibelle = false;
        } else {
            this.validSecteurLibelle = true;
        }
    }




   public async openCreateVille(ville: string) {
        const isPermistted = await this.roleService.isPermitted('Ville', 'edit');
        if (isPermistted) {
             this.ville = new VilleDto();
             this.createVilleDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

    get ville(): VilleDto {
        return this.villeService.item;
    }
    set ville(value: VilleDto) {
        this.villeService.item = value;
    }
    get villes(): Array<VilleDto> {
        return this.villeService.items;
    }
    set villes(value: Array<VilleDto>) {
        this.villeService.items = value;
    }
    get createVilleDialog(): boolean {
        return this.villeService.createDialog;
    }
    set createVilleDialog(value: boolean) {
        this.villeService.createDialog= value;
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

    get validVilleCode(): boolean {
        return this._validVilleCode;
    }
    set validVilleCode(value: boolean) {
        this._validVilleCode = value;
    }
    get validVilleLibelle(): boolean {
        return this._validVilleLibelle;
    }
    set validVilleLibelle(value: boolean) {
        this._validVilleLibelle = value;
    }

	get items(): Array<SecteurDto> {
        return this.service.items;
    }

    set items(value: Array<SecteurDto>) {
        this.service.items = value;
    }

    get item(): SecteurDto {
        return this.service.item;
    }

    set item(value: SecteurDto) {
        this.service.item = value;
    }

    get editDialog(): boolean {
        return this.service.editDialog;
    }

    set editDialog(value: boolean) {
        this.service.editDialog = value;
    }

    get criteria(): SecteurCriteria {
        return this.service.criteria;
    }

    set criteria(value: SecteurCriteria) {
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
