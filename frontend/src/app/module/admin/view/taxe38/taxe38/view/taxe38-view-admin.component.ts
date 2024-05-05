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


import {Taxe38AdminService} from 'src/app/shared/service/admin/taxe38/Taxe38Admin.service';
import {Taxe38Dto} from 'src/app/shared/model/taxe38/Taxe38.model';
import {Taxe38Criteria} from 'src/app/shared/criteria/taxe38/Taxe38Criteria.model';

import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';
import {Taxe38DetailDto} from 'src/app/shared/model/taxe38/Taxe38Detail.model';
import {Taxe38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Taxe38DetailAdmin.service';
import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Locale38DetailAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';
@Component({
  selector: 'app-taxe38-view-admin',
  templateUrl: './taxe38-view-admin.component.html'
})
export class Taxe38ViewAdminComponent implements OnInit {


	protected _submitted = false;
    protected _errorMessages = new Array<string>();

    protected datePipe: DatePipe;
    protected messageService: MessageService;
    protected confirmationService: ConfirmationService;
    protected roleService: RoleService;
    protected router: Router;
    protected stringUtilService: StringUtilService;


    taxe38Details = new Taxe38DetailDto();
    taxe38Detailss: Array<Taxe38DetailDto> = [];

    constructor(private service: Taxe38AdminService, private localeService: LocaleAdminService, private trimService: TrimAdminService, private taxe38DetailService: Taxe38DetailAdminService, private locale38DetailService: Locale38DetailAdminService, private redevableService: RedevableAdminService, private tauxTaxe38Service: TauxTaxe38AdminService){
		this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
	}

    ngOnInit(): void {
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

    public hideViewDialog() {
        this.viewDialog = false;
    }

    get items(): Array<Taxe38Dto> {
        return this.service.items;
    }

    set items(value: Array<Taxe38Dto>) {
        this.service.items = value;
    }

    get item(): Taxe38Dto {
        return this.service.item;
    }

    set item(value: Taxe38Dto) {
        this.service.item = value;
    }

    get viewDialog(): boolean {
        return this.service.viewDialog;
    }

    set viewDialog(value: boolean) {
        this.service.viewDialog = value;
    }

    get criteria(): Taxe38Criteria {
        return this.service.criteria;
    }

    set criteria(value: Taxe38Criteria) {
        this.service.criteria = value;
    }

    get dateFormat(){
        return environment.dateFormatView;
    }

    get dateFormatColumn(){
        return environment.dateFormatList;
    }


}
