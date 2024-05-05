import {Component, OnInit} from '@angular/core';
import {Taxe38AdminService} from 'src/app/shared/service/admin/taxe38/Taxe38Admin.service';
import {Taxe38Dto} from 'src/app/shared/model/taxe38/Taxe38.model';
import {Taxe38Criteria} from 'src/app/shared/criteria/taxe38/Taxe38Criteria.model';


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
  selector: 'app-taxe38-list-admin',
  templateUrl: './taxe38-list-admin.component.html'
})
export class Taxe38ListAdminComponent implements OnInit {

    protected fileName = 'Taxe38';

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


    redevables: Array<RedevableDto>;
    locales: Array<LocaleDto>;
    trims: Array<TrimDto>;


    constructor( private service: Taxe38AdminService  , private localeService: LocaleAdminService, private trimService: TrimAdminService, private taxe38DetailService: Taxe38DetailAdminService, private locale38DetailService: Locale38DetailAdminService, private redevableService: RedevableAdminService, private tauxTaxe38Service: TauxTaxe38AdminService, @Inject(PLATFORM_ID) private platformId?) {
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
        this.loadRedevable();
        this.loadLocale();
        this.loadTrim();

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
            this.selections = new Array<Taxe38Dto>();
        }, error => console.log(error));
    }

    public onPage(event: any) {
        this.criteria.page = event.page;
        this.criteria.maxResults = event.rows;
        this.findPaginatedByCriteria();
    }

    public async edit(dto: Taxe38Dto) {
        this.service.findByIdWithAssociatedList(dto).subscribe(res => {
            this.item = res;
            console.log(res);
            this.editDialog = true;
        });

    }

    public async view(dto: Taxe38Dto) {
        this.service.findByIdWithAssociatedList(dto).subscribe(res => {
            this.item = res;
            this.viewDialog = true;
        });
    }

    public async openCreate() {
        this.item = new Taxe38Dto();
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
                    this.selections = new Array<Taxe38Dto>();
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


    public async delete(dto: Taxe38Dto) {

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

    public async duplicate(dto: Taxe38Dto) {
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

    public exportPdf(dto: Taxe38Dto): void {
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
            this.item = new Taxe38Dto();
        } , error => {
            console.log(error);
        });
    }

    public save() {
        this.service.save().subscribe(item => {
            if (item != null) {
                this.items.push({...item});
                this.createDialog = false;


                this.item = new Taxe38Dto();
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
            {field: 'redevable?.id', header: 'Redevable'},
            {field: 'locale?.code', header: 'Locale'},
            {field: 'anne', header: 'Anne'},
            {field: 'trim?.id', header: 'Trim'},
            {field: 'datePresentaion', header: 'Date presentaion'},
            {field: 'nombreMoisRetard', header: 'Nombre mois retard'},
            {field: 'montantBase', header: 'Montant base'},
            {field: 'montantRetardPremeirMois', header: 'Montant retard premeir mois'},
            {field: 'montantTotal', header: 'Montant total'},
        ];
    }


    public async loadRedevable(){
        this.redevableService.findAll().subscribe(redevables => this.redevables = redevables, error => console.log(error))
    }
    public async loadLocale(){
        this.localeService.findAllOptimized().subscribe(locales => this.locales = locales, error => console.log(error))
    }
    public async loadTrim(){
        this.trimService.findAll().subscribe(trims => this.trims = trims, error => console.log(error))
    }


	public initDuplicate(res: Taxe38Dto) {
        if (res.taxe38Details != null) {
             res.taxe38Details.forEach(d => { d.taxe38 = null; d.id = null; });
        }
	}



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                'Redevable': e.redevable?.id ,
                'Locale': e.locale?.code ,
                 'Anne': e.anne ,
                'Trim': e.trim?.id ,
                'Date presentaion': this.datePipe.transform(e.datePresentaion , 'dd/MM/yyyy hh:mm'),
                 'Nombre mois retard': e.nombreMoisRetard ,
                 'Montant base': e.montantBase ,
                 'Montant retard premeir mois': e.montantRetardPremeirMois ,
                 'Montant total': e.montantTotal ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Redevable': this.criteria.redevable?.id ? this.criteria.redevable?.id : environment.emptyForExport ,
        //'Locale': this.criteria.locale?.code ? this.criteria.locale?.code : environment.emptyForExport ,
            'Anne Min': this.criteria.anneMin ? this.criteria.anneMin : environment.emptyForExport ,
            'Anne Max': this.criteria.anneMax ? this.criteria.anneMax : environment.emptyForExport ,
        //'Trim': this.criteria.trim?.id ? this.criteria.trim?.id : environment.emptyForExport ,
            'Date presentaion Min': this.criteria.datePresentaionFrom ? this.datePipe.transform(this.criteria.datePresentaionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date presentaion Max': this.criteria.datePresentaionTo ? this.datePipe.transform(this.criteria.datePresentaionTo , this.dateFormat) : environment.emptyForExport ,
            'Nombre mois retard Min': this.criteria.nombreMoisRetardMin ? this.criteria.nombreMoisRetardMin : environment.emptyForExport ,
            'Nombre mois retard Max': this.criteria.nombreMoisRetardMax ? this.criteria.nombreMoisRetardMax : environment.emptyForExport ,
            'Montant base Min': this.criteria.montantBaseMin ? this.criteria.montantBaseMin : environment.emptyForExport ,
            'Montant base Max': this.criteria.montantBaseMax ? this.criteria.montantBaseMax : environment.emptyForExport ,
            'Montant retard premeir mois Min': this.criteria.montantRetardPremeirMoisMin ? this.criteria.montantRetardPremeirMoisMin : environment.emptyForExport ,
            'Montant retard premeir mois Max': this.criteria.montantRetardPremeirMoisMax ? this.criteria.montantRetardPremeirMoisMax : environment.emptyForExport ,
            'Montant total Min': this.criteria.montantTotalMin ? this.criteria.montantTotalMin : environment.emptyForExport ,
            'Montant total Max': this.criteria.montantTotalMax ? this.criteria.montantTotalMax : environment.emptyForExport ,
        }];
      }



    get items(): Array<Taxe38Dto> {
        return this.service.items;
    }

    set items(value: Array<Taxe38Dto>) {
        this.service.items = value;
    }

    get selections(): Array<Taxe38Dto> {
        return this.service.selections;
    }

    set selections(value: Array<Taxe38Dto>) {
        this.service.selections = value;
    }

    get item(): Taxe38Dto {
        return this.service.item;
    }

    set item(value: Taxe38Dto) {
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

    get criteria(): Taxe38Criteria {
        return this.service.criteria;
    }

    set criteria(value: Taxe38Criteria) {
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
