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


import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleCriteria} from 'src/app/shared/criteria/commun/LocaleCriteria.model';

import {RueDto} from 'src/app/shared/model/commun/Rue.model';
import {RueAdminService} from 'src/app/shared/service/admin/commun/RueAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';
import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleAdminService} from 'src/app/shared/service/admin/taxe38/CategorieLocaleAdmin.service';
@Component({
  selector: 'app-locale-view-admin',
  templateUrl: './locale-view-admin.component.html'
})
export class LocaleViewAdminComponent implements OnInit {


	protected _submitted = false;
    protected _errorMessages = new Array<string>();

    protected datePipe: DatePipe;
    protected messageService: MessageService;
    protected confirmationService: ConfirmationService;
    protected roleService: RoleService;
    protected router: Router;
    protected stringUtilService: StringUtilService;



    constructor(private service: LocaleAdminService, private rueService: RueAdminService, private redevableService: RedevableAdminService, private categorieLocaleService: CategorieLocaleAdminService){
		this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.stringUtilService = ServiceLocator.injector.get(StringUtilService);
	}

    ngOnInit(): void {
    }


    get rue(): RueDto {
        return this.rueService.item;
    }
    set rue(value: RueDto) {
        this.rueService.item = value;
    }
    get rues(): Array<RueDto> {
        return this.rueService.items;
    }
    set rues(value: Array<RueDto>) {
        this.rueService.items = value;
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
    get categorieLocale(): CategorieLocaleDto {
        return this.categorieLocaleService.item;
    }
    set categorieLocale(value: CategorieLocaleDto) {
        this.categorieLocaleService.item = value;
    }
    get categorieLocales(): Array<CategorieLocaleDto> {
        return this.categorieLocaleService.items;
    }
    set categorieLocales(value: Array<CategorieLocaleDto>) {
        this.categorieLocaleService.items = value;
    }

    public hideViewDialog() {
        this.viewDialog = false;
    }

    get items(): Array<LocaleDto> {
        return this.service.items;
    }

    set items(value: Array<LocaleDto>) {
        this.service.items = value;
    }

    get item(): LocaleDto {
        return this.service.item;
    }

    set item(value: LocaleDto) {
        this.service.item = value;
    }

    get viewDialog(): boolean {
        return this.service.viewDialog;
    }

    set viewDialog(value: boolean) {
        this.service.viewDialog = value;
    }

    get criteria(): LocaleCriteria {
        return this.service.criteria;
    }

    set criteria(value: LocaleCriteria) {
        this.service.criteria = value;
    }

    get dateFormat(){
        return environment.dateFormatView;
    }

    get dateFormatColumn(){
        return environment.dateFormatList;
    }


}
