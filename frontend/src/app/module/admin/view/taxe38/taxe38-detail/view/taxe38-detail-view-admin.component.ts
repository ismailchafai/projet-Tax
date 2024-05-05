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


import {Taxe38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Taxe38DetailAdmin.service';
import {Taxe38DetailDto} from 'src/app/shared/model/taxe38/Taxe38Detail.model';
import {Taxe38DetailCriteria} from 'src/app/shared/criteria/taxe38/Taxe38DetailCriteria.model';

import {Taxe38Dto} from 'src/app/shared/model/taxe38/Taxe38.model';
import {Taxe38AdminService} from 'src/app/shared/service/admin/taxe38/Taxe38Admin.service';
import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Locale38DetailAdmin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';
@Component({
  selector: 'app-taxe38-detail-view-admin',
  templateUrl: './taxe38-detail-view-admin.component.html'
})
export class Taxe38DetailViewAdminComponent implements OnInit {


	protected _submitted = false;
    protected _errorMessages = new Array<string>();

    protected datePipe: DatePipe;
    protected messageService: MessageService;
    protected confirmationService: ConfirmationService;
    protected roleService: RoleService;
    protected router: Router;
    protected stringUtilService: StringUtilService;



    constructor(private service: Taxe38DetailAdminService, private taxe38Service: Taxe38AdminService, private locale38DetailService: Locale38DetailAdminService, private tauxTaxe38Service: TauxTaxe38AdminService){
		this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
	}

    ngOnInit(): void {
    }


    get locale38Detail(): Locale38DetailDto {
        return this.locale38DetailService.item;
    }
    set locale38Detail(value: Locale38DetailDto) {
        this.locale38DetailService.item = value;
    }
    get locale38Details(): Array<Locale38DetailDto> {
        return this.locale38DetailService.items;
    }
    set locale38Details(value: Array<Locale38DetailDto>) {
        this.locale38DetailService.items = value;
    }
    get tauxTaxe38(): TauxTaxe38Dto {
        return this.tauxTaxe38Service.item;
    }
    set tauxTaxe38(value: TauxTaxe38Dto) {
        this.tauxTaxe38Service.item = value;
    }
    get tauxTaxe38s(): Array<TauxTaxe38Dto> {
        return this.tauxTaxe38Service.items;
    }
    set tauxTaxe38s(value: Array<TauxTaxe38Dto>) {
        this.tauxTaxe38Service.items = value;
    }
    get taxe38(): Taxe38Dto {
        return this.taxe38Service.item;
    }
    set taxe38(value: Taxe38Dto) {
        this.taxe38Service.item = value;
    }
    get taxe38s(): Array<Taxe38Dto> {
        return this.taxe38Service.items;
    }
    set taxe38s(value: Array<Taxe38Dto>) {
        this.taxe38Service.items = value;
    }

    public hideViewDialog() {
        this.viewDialog = false;
    }

    get items(): Array<Taxe38DetailDto> {
        return this.service.items;
    }

    set items(value: Array<Taxe38DetailDto>) {
        this.service.items = value;
    }

    get item(): Taxe38DetailDto {
        return this.service.item;
    }

    set item(value: Taxe38DetailDto) {
        this.service.item = value;
    }

    get viewDialog(): boolean {
        return this.service.viewDialog;
    }

    set viewDialog(value: boolean) {
        this.service.viewDialog = value;
    }

    get criteria(): Taxe38DetailCriteria {
        return this.service.criteria;
    }

    set criteria(value: Taxe38DetailCriteria) {
        this.service.criteria = value;
    }

    get dateFormat(){
        return environment.dateFormatView;
    }

    get dateFormatColumn(){
        return environment.dateFormatList;
    }


}
