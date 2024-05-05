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


import {RueAdminService} from 'src/app/shared/service/admin/commun/RueAdmin.service';
import {RueDto} from 'src/app/shared/model/commun/Rue.model';
import {RueCriteria} from 'src/app/shared/criteria/commun/RueCriteria.model';

import {QuartierDto} from 'src/app/shared/model/commun/Quartier.model';
import {QuartierAdminService} from 'src/app/shared/service/admin/commun/QuartierAdmin.service';
@Component({
  selector: 'app-rue-view-admin',
  templateUrl: './rue-view-admin.component.html'
})
export class RueViewAdminComponent implements OnInit {


	protected _submitted = false;
    protected _errorMessages = new Array<string>();

    protected datePipe: DatePipe;
    protected messageService: MessageService;
    protected confirmationService: ConfirmationService;
    protected roleService: RoleService;
    protected router: Router;
    protected stringUtilService: StringUtilService;



    constructor(private service: RueAdminService, private quartierService: QuartierAdminService){
		this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
	}

    ngOnInit(): void {
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

    public hideViewDialog() {
        this.viewDialog = false;
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

    get viewDialog(): boolean {
        return this.service.viewDialog;
    }

    set viewDialog(value: boolean) {
        this.service.viewDialog = value;
    }

    get criteria(): RueCriteria {
        return this.service.criteria;
    }

    set criteria(value: RueCriteria) {
        this.service.criteria = value;
    }

    get dateFormat(){
        return environment.dateFormatView;
    }

    get dateFormatColumn(){
        return environment.dateFormatList;
    }


}
