import {Component, OnInit} from '@angular/core';


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
import {ConfirmationService, MessageService,MenuItem} from 'primeng/api';
import {FileTempDto} from 'src/app/zynerator/dto/FileTempDto.model';


import {QuartierAdminService} from 'src/app/shared/service/admin/commun/QuartierAdmin.service';
import {QuartierDto} from 'src/app/shared/model/commun/Quartier.model';
import {QuartierCriteria} from 'src/app/shared/criteria/commun/QuartierCriteria.model';

import {SecteurDto} from 'src/app/shared/model/commun/Secteur.model';
import {SecteurAdminService} from 'src/app/shared/service/admin/commun/SecteurAdmin.service';
@Component({
  selector: 'app-quartier-view-admin',
  templateUrl: './quartier-view-admin.component.html'
})
export class QuartierViewAdminComponent implements OnInit {


	protected _submitted = false;
    protected _errorMessages = new Array<string>();

    protected datePipe: DatePipe;
    protected messageService: MessageService;
    protected confirmationService: ConfirmationService;
    protected roleService: RoleService;
    protected router: Router;
    protected stringUtilService: StringUtilService;



    constructor(private service: QuartierAdminService, private secteurService: SecteurAdminService){
		this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
	}

    ngOnInit(): void {
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

    public hideViewDialog() {
        this.viewDialog = false;
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

    get viewDialog(): boolean {
        return this.service.viewDialog;
    }

    set viewDialog(value: boolean) {
        this.service.viewDialog = value;
    }

    get criteria(): QuartierCriteria {
        return this.service.criteria;
    }

    set criteria(value: QuartierCriteria) {
        this.service.criteria = value;
    }

    get dateFormat(){
        return environment.dateFormatView;
    }

    get dateFormatColumn(){
        return environment.dateFormatList;
    }


}
