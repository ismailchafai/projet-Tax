import {Component, OnInit} from '@angular/core';
import {NotificationRetardDeuxiemeNiveauAdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauAdmin.service';
import {NotificationRetardDeuxiemeNiveauDto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveau.model';
import {NotificationRetardDeuxiemeNiveauCriteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauCriteria.model';


import {ConfirmationService, MessageService,MenuItem} from 'primeng/api';
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

import {AuthService} from 'src/app/zynerator/security/shared/service/Auth.service';
import {ExportService} from 'src/app/zynerator/util/Export.service';


import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';


@Component({
  selector: 'app-notification-retard-deuxieme-niveau-list-admin',
  templateUrl: './notification-retard-deuxieme-niveau-list-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauListAdminComponent implements OnInit {

    protected fileName = 'NotificationRetardDeuxiemeNiveau';

    protected findByCriteriaShow = false;
    protected cols: any[] = [];
    protected excelPdfButons: MenuItem[];
    protected exportData: any[] = [];
    protected criteriaData: any[] = [];
    protected _totalRecords = 0;
    private _pdfName: string;


    protected datePipe: DatePipe;
    protected messageService: MessageService;
    protected confirmationService: ConfirmationService;
    protected roleService: RoleService;
    protected router: Router;
    protected stringUtilService: StringUtilService;
    protected authService: AuthService;
    protected exportService: ExportService;
    protected excelFile: File | undefined;
    protected enableSecurity = false;


    locales: Array<LocaleDto>;
    redevables: Array<RedevableDto>;


    constructor( private service: NotificationRetardDeuxiemeNiveauAdminService  , private localeService: LocaleAdminService, private redevableService: RedevableAdminService, @Inject(PLATFORM_ID) private platformId?) {
        this.datePipe = ServiceLocator.injector.get(DatePipe);
        this.messageService = ServiceLocator.injector.get(MessageService);
        this.confirmationService = ServiceLocator.injector.get(ConfirmationService);
        this.roleService = ServiceLocator.injector.get(RoleService);
        this.router = ServiceLocator.injector.get(Router);
        this.authService = ServiceLocator.injector.get(AuthService);
        this.exportService = ServiceLocator.injector.get(ExportService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadLocale();
        this.loadRedevable();

    }




    public onExcelFileSelected(event: any): void {
        const input = event.target as HTMLInputElement;
        if (input.files && input.files.length > 0) {
            this.excelFile = input.files[0];
        }
    }

    public importExcel(): void {
        if (this.excelFile) {
            this.service.importExcel(this.excelFile).subscribe(
                response => {
                    console.log('File uploaded successfully!', response);
                },
                error => {
                    console.error('Error uploading file:', error);
                }
            );
        }
    }

    public findPaginatedByCriteria() {
        this.service.findPaginatedByCriteria(this.criteria).subscribe(paginatedItems => {
            this.items = paginatedItems.list;
            this.totalRecords = paginatedItems.dataSize;
            this.selections = new Array<NotificationRetardDeuxiemeNiveauDto>();
        }, error => console.log(error));
    }

    public onPage(event: any) {
        this.criteria.page = event.page;
        this.criteria.maxResults = event.rows;
        this.findPaginatedByCriteria();
    }

    public async edit(dto: NotificationRetardDeuxiemeNiveauDto) {
        this.service.findByIdWithAssociatedList(dto).subscribe(res => {
            this.item = res;
            console.log(res);
            this.editDialog = true;
        });

    }

    public async view(dto: NotificationRetardDeuxiemeNiveauDto) {
        this.service.findByIdWithAssociatedList(dto).subscribe(res => {
            this.item = res;
            this.viewDialog = true;
        });
    }

    public async openCreate() {
        this.item = new NotificationRetardDeuxiemeNiveauDto();
        this.createDialog = true;
    }

    public async deleteMultiple() {
        this.confirmationService.confirm({
            message: 'Voulez-vous supprimer ces éléments ?',
            header: 'Confirmation',
            icon: 'pi pi-exclamation-triangle',
            accept: () => {
                this.service.deleteMultiple().subscribe(() => {
                    this.items = this.items.filter(item => !this.selections.includes(item));
                    this.selections = new Array<NotificationRetardDeuxiemeNiveauDto>();
                    this.messageService.add({
                        severity: 'success',
                        summary: 'Succès',
                        detail: 'Les éléments sélectionnés ont été supprimés',
                        life: 3000
                    });

                }, error => console.log(error));
            }
        });
    }


    public isSelectionDisabled(): boolean {
        return this.selections == null || this.selections.length == 0;
    }


    public async delete(dto: NotificationRetardDeuxiemeNiveauDto) {

        this.confirmationService.confirm({
            message: 'Voulez-vous supprimer cet élément ?',
            header: 'Confirmation',
            icon: 'pi pi-exclamation-triangle',
            accept: () => {
                this.service.delete(dto).subscribe(status => {
                    if (status > 0) {
                        const position = this.items.indexOf(dto);
                        position > -1 ? this.items.splice(position, 1) : false;
                        this.messageService.add({
                            severity: 'success',
                            summary: 'Succès',
                            detail: 'Element Supprimé',
                            life: 3000
                        });
                    }

                }, error => console.log(error));
            }
        });

    }

    public async duplicate(dto: NotificationRetardDeuxiemeNiveauDto) {
        this.service.findByIdWithAssociatedList(dto).subscribe(
            res => {
                this.initDuplicate(res);
                this.item = res;
                this.item.id = null;
                this.createDialog = true;
            });
    }

    // TODO : check if correct
    public initExport(): void {
        this.excelPdfButons = [
            {
                label: 'CSV', icon: 'pi pi-file', command: () => {
                    this.prepareColumnExport();
                    this.exportService.exporterCSV(this.criteriaData, this.exportData, this.fileName);
                }
            },
            {
                label: 'XLS', icon: 'pi pi-file-excel', command: () => {
                    this.prepareColumnExport();
                    this.exportService.exporterExcel(this.criteriaData, this.exportData, this.fileName);
                }
            },
            {
                label: 'PDF', icon: 'pi pi-file-pdf', command: () => {
                    this.prepareColumnExport();
                    this.exportService.exporterPdf(this.criteriaData, this.exportData, this.fileName);
                }
            }
        ];
    }

    public exportPdf(dto: NotificationRetardDeuxiemeNiveauDto): void {
        this.service.exportPdf(dto).subscribe((data: ArrayBuffer) => {
            const blob = new Blob([data], {type: 'application/pdf'});
            const url = window.URL.createObjectURL(blob);
            const link = document.createElement('a');
            link.href = url;
            link.download = this.pdfName;
            link.setAttribute('target', '_blank'); // open link in new tab
            link.click();
            window.URL.revokeObjectURL(url);
        }, (error) => {
            console.error(error); // handle any errors that occur
        });
    }

    public showSearch(): void {
        this.findByCriteriaShow = !this.findByCriteriaShow;
    }


    update() {
        this.service.edit().subscribe(data => {
            const myIndex = this.items.findIndex(e => e.id === this.item.id);
            this.items[myIndex] = data;
            this.editDialog = false;
            this.item = new NotificationRetardDeuxiemeNiveauDto();
        } , error => {
            console.log(error);
        });
    }

    public save() {
        this.service.save().subscribe(item => {
            if (item != null) {
                this.items.push({...item});
                this.createDialog = false;


                this.item = new NotificationRetardDeuxiemeNiveauDto();
            } else {
                this.messageService.add({severity: 'error', summary: 'Erreurs', detail: 'Element existant'});
            }
        }, error => {
            console.log(error);
        });
    }

// add


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'locale?.code', header: 'Locale'},
            {field: 'redevable?.id', header: 'Redevable'},
            {field: 'anne', header: 'Anne'},
            {field: 'montantBase', header: 'Montant base'},
            {field: 'montantRetardPremierMois', header: 'Montant retard premier mois'},
            {field: 'montantRetardAutreMois', header: 'Montant retard autre mois'},
            {field: 'montantTotal', header: 'Montant total'},
        ];
    }


    public async loadLocale(){
        this.localeService.findAllOptimized().subscribe(locales => this.locales = locales, error => console.log(error))
    }
    public async loadRedevable(){
        this.redevableService.findAll().subscribe(redevables => this.redevables = redevables, error => console.log(error))
    }


	public initDuplicate(res: NotificationRetardDeuxiemeNiveauDto) {
	}



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                'Locale': e.locale?.code ,
                'Redevable': e.redevable?.id ,
                 'Anne': e.anne ,
                 'Montant base': e.montantBase ,
                 'Montant retard premier mois': e.montantRetardPremierMois ,
                 'Montant retard autre mois': e.montantRetardAutreMois ,
                 'Montant total': e.montantTotal ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Locale': this.criteria.locale?.code ? this.criteria.locale?.code : environment.emptyForExport ,
        //'Redevable': this.criteria.redevable?.id ? this.criteria.redevable?.id : environment.emptyForExport ,
            'Anne Min': this.criteria.anneMin ? this.criteria.anneMin : environment.emptyForExport ,
            'Anne Max': this.criteria.anneMax ? this.criteria.anneMax : environment.emptyForExport ,
            'Montant base Min': this.criteria.montantBaseMin ? this.criteria.montantBaseMin : environment.emptyForExport ,
            'Montant base Max': this.criteria.montantBaseMax ? this.criteria.montantBaseMax : environment.emptyForExport ,
            'Montant retard premier mois Min': this.criteria.montantRetardPremierMoisMin ? this.criteria.montantRetardPremierMoisMin : environment.emptyForExport ,
            'Montant retard premier mois Max': this.criteria.montantRetardPremierMoisMax ? this.criteria.montantRetardPremierMoisMax : environment.emptyForExport ,
            'Montant retard autre mois Min': this.criteria.montantRetardAutreMoisMin ? this.criteria.montantRetardAutreMoisMin : environment.emptyForExport ,
            'Montant retard autre mois Max': this.criteria.montantRetardAutreMoisMax ? this.criteria.montantRetardAutreMoisMax : environment.emptyForExport ,
            'Montant total Min': this.criteria.montantTotalMin ? this.criteria.montantTotalMin : environment.emptyForExport ,
            'Montant total Max': this.criteria.montantTotalMax ? this.criteria.montantTotalMax : environment.emptyForExport ,
        }];
      }



    get items(): Array<NotificationRetardDeuxiemeNiveauDto> {
        return this.service.items;
    }

    set items(value: Array<NotificationRetardDeuxiemeNiveauDto>) {
        this.service.items = value;
    }

    get selections(): Array<NotificationRetardDeuxiemeNiveauDto> {
        return this.service.selections;
    }

    set selections(value: Array<NotificationRetardDeuxiemeNiveauDto>) {
        this.service.selections = value;
    }

    get item(): NotificationRetardDeuxiemeNiveauDto {
        return this.service.item;
    }

    set item(value: NotificationRetardDeuxiemeNiveauDto) {
        this.service.item = value;
    }

    get createDialog(): boolean {
        return this.service.createDialog;
    }

    set createDialog(value: boolean) {
        this.service.createDialog = value;
    }

    get editDialog(): boolean {
        return this.service.editDialog;
    }

    set editDialog(value: boolean) {
        this.service.editDialog = value;
    }

    get viewDialog(): boolean {
        return this.service.viewDialog;
    }

    set viewDialog(value: boolean) {
        this.service.viewDialog = value;
    }

    get criteria(): NotificationRetardDeuxiemeNiveauCriteria {
        return this.service.criteria;
    }

    set criteria(value: NotificationRetardDeuxiemeNiveauCriteria) {
        this.service.criteria = value;
    }

    get dateFormat() {
        return environment.dateFormatList;
    }


    get totalRecords(): number {
        return this._totalRecords;
    }

    set totalRecords(value: number) {
        this._totalRecords = value;
    }

    get pdfName(): string {
        return this._pdfName;
    }

    set pdfName(value: string) {
        this._pdfName = value;
    }

    get createActionIsValid(): boolean {
        return this.service.createActionIsValid;
    }

    set createActionIsValid(value: boolean) {
        this.service.createActionIsValid = value;
    }


    get editActionIsValid(): boolean {
        return this.service.editActionIsValid;
    }

    set editActionIsValid(value: boolean) {
        this.service.editActionIsValid = value;
    }

    get listActionIsValid(): boolean {
        return this.service.listActionIsValid;
    }

    set listActionIsValid(value: boolean) {
        this.service.listActionIsValid = value;
    }

    get deleteActionIsValid(): boolean {
        return this.service.deleteActionIsValid;
    }

    set deleteActionIsValid(value: boolean) {
        this.service.deleteActionIsValid = value;
    }


    get viewActionIsValid(): boolean {
        return this.service.viewActionIsValid;
    }

    set viewActionIsValid(value: boolean) {
        this.service.viewActionIsValid = value;
    }

    get duplicateActionIsValid(): boolean {
        return this.service.duplicateActionIsValid;
    }

    set duplicateActionIsValid(value: boolean) {
        this.service.duplicateActionIsValid = value;
    }

    get createAction(): string {
        return this.service.createAction;
    }

    set createAction(value: string) {
        this.service.createAction = value;
    }

    get listAction(): string {
        return this.service.listAction;
    }

    set listAction(value: string) {
        this.service.listAction = value;
    }

    get editAction(): string {
        return this.service.editAction;
    }

    set editAction(value: string) {
        this.service.editAction = value;
    }

    get deleteAction(): string {
        return this.service.deleteAction;
    }

    set deleteAction(value: string) {
        this.service.deleteAction = value;
    }

    get viewAction(): string {
        return this.service.viewAction;
    }

    set viewAction(value: string) {
        this.service.viewAction = value;
    }

    get duplicateAction(): string {
        return this.service.duplicateAction;
    }

    set duplicateAction(value: string) {
        this.service.duplicateAction = value;
    }

    get entityName(): string {
        return this.service.entityName;
    }

    set entityName(value: string) {
        this.service.entityName = value;
    }
}
