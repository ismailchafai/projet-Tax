import {Component, OnInit} from '@angular/core';
import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38Criteria} from 'src/app/shared/criteria/taxe38/TauxTaxe38Criteria.model';


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


import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleAdminService} from 'src/app/shared/service/admin/taxe38/CategorieLocaleAdmin.service';


@Component({
  selector: 'app-taux-taxe38-list-admin',
  templateUrl: './taux-taxe38-list-admin.component.html'
})
export class TauxTaxe38ListAdminComponent implements OnInit {

    protected fileName = 'TauxTaxe38';

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


    typeLocale38Details: Array<TypeLocale38DetailDto>;
    categorieLocales: Array<CategorieLocaleDto>;


    constructor( private service: TauxTaxe38AdminService  , private typeLocale38DetailService: TypeLocale38DetailAdminService, private categorieLocaleService: CategorieLocaleAdminService, @Inject(PLATFORM_ID) private platformId?) {
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
        this.loadTypeLocale38Detail();
        this.loadCategorieLocale();

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
            this.selections = new Array<TauxTaxe38Dto>();
        }, error => console.log(error));
    }

    public onPage(event: any) {
        this.criteria.page = event.page;
        this.criteria.maxResults = event.rows;
        this.findPaginatedByCriteria();
    }

    public async edit(dto: TauxTaxe38Dto) {
        this.service.findByIdWithAssociatedList(dto).subscribe(res => {
            this.item = res;
            console.log(res);
            this.editDialog = true;
        });

    }

    public async view(dto: TauxTaxe38Dto) {
        this.service.findByIdWithAssociatedList(dto).subscribe(res => {
            this.item = res;
            this.viewDialog = true;
        });
    }

    public async openCreate() {
        this.item = new TauxTaxe38Dto();
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
                    this.selections = new Array<TauxTaxe38Dto>();
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


    public async delete(dto: TauxTaxe38Dto) {

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

    public async duplicate(dto: TauxTaxe38Dto) {
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

    public exportPdf(dto: TauxTaxe38Dto): void {
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
            this.item = new TauxTaxe38Dto();
        } , error => {
            console.log(error);
        });
    }

    public save() {
        this.service.save().subscribe(item => {
            if (item != null) {
                this.items.push({...item});
                this.createDialog = false;


                this.item = new TauxTaxe38Dto();
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
            {field: 'montantParMetreCarre', header: 'Montant par metre carre'},
            {field: 'dateMin', header: 'Date min'},
            {field: 'dateMax', header: 'Date max'},
            {field: 'pourcentagePremierRetard', header: 'Pourcentage premier retard'},
            {field: 'pourcentageAutreMoisRetard', header: 'Pourcentage autre mois retard'},
            {field: 'typeLocale38Detail?.code', header: 'Type locale38 detail'},
            {field: 'categorieLocale?.code', header: 'Categorie locale'},
        ];
    }


    public async loadTypeLocale38Detail(){
        this.typeLocale38DetailService.findAllOptimized().subscribe(typeLocale38Details => this.typeLocale38Details = typeLocale38Details, error => console.log(error))
    }
    public async loadCategorieLocale(){
        this.categorieLocaleService.findAllOptimized().subscribe(categorieLocales => this.categorieLocales = categorieLocales, error => console.log(error))
    }


	public initDuplicate(res: TauxTaxe38Dto) {
	}



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Montant par metre carre': e.montantParMetreCarre ,
                'Date min': this.datePipe.transform(e.dateMin , 'dd/MM/yyyy hh:mm'),
                'Date max': this.datePipe.transform(e.dateMax , 'dd/MM/yyyy hh:mm'),
                 'Pourcentage premier retard': e.pourcentagePremierRetard ,
                 'Pourcentage autre mois retard': e.pourcentageAutreMoisRetard ,
                'Type locale38 detail': e.typeLocale38Detail?.code ,
                'Categorie locale': e.categorieLocale?.code ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Montant par metre carre Min': this.criteria.montantParMetreCarreMin ? this.criteria.montantParMetreCarreMin : environment.emptyForExport ,
            'Montant par metre carre Max': this.criteria.montantParMetreCarreMax ? this.criteria.montantParMetreCarreMax : environment.emptyForExport ,
            'Date min Min': this.criteria.dateMinFrom ? this.datePipe.transform(this.criteria.dateMinFrom , this.dateFormat) : environment.emptyForExport ,
            'Date min Max': this.criteria.dateMinTo ? this.datePipe.transform(this.criteria.dateMinTo , this.dateFormat) : environment.emptyForExport ,
            'Date max Min': this.criteria.dateMaxFrom ? this.datePipe.transform(this.criteria.dateMaxFrom , this.dateFormat) : environment.emptyForExport ,
            'Date max Max': this.criteria.dateMaxTo ? this.datePipe.transform(this.criteria.dateMaxTo , this.dateFormat) : environment.emptyForExport ,
            'Pourcentage premier retard Min': this.criteria.pourcentagePremierRetardMin ? this.criteria.pourcentagePremierRetardMin : environment.emptyForExport ,
            'Pourcentage premier retard Max': this.criteria.pourcentagePremierRetardMax ? this.criteria.pourcentagePremierRetardMax : environment.emptyForExport ,
            'Pourcentage autre mois retard Min': this.criteria.pourcentageAutreMoisRetardMin ? this.criteria.pourcentageAutreMoisRetardMin : environment.emptyForExport ,
            'Pourcentage autre mois retard Max': this.criteria.pourcentageAutreMoisRetardMax ? this.criteria.pourcentageAutreMoisRetardMax : environment.emptyForExport ,
        //'Type locale38 detail': this.criteria.typeLocale38Detail?.code ? this.criteria.typeLocale38Detail?.code : environment.emptyForExport ,
        //'Categorie locale': this.criteria.categorieLocale?.code ? this.criteria.categorieLocale?.code : environment.emptyForExport ,
        }];
      }



    get items(): Array<TauxTaxe38Dto> {
        return this.service.items;
    }

    set items(value: Array<TauxTaxe38Dto>) {
        this.service.items = value;
    }

    get selections(): Array<TauxTaxe38Dto> {
        return this.service.selections;
    }

    set selections(value: Array<TauxTaxe38Dto>) {
        this.service.selections = value;
    }

    get item(): TauxTaxe38Dto {
        return this.service.item;
    }

    set item(value: TauxTaxe38Dto) {
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

    get criteria(): TauxTaxe38Criteria {
        return this.service.criteria;
    }

    set criteria(value: TauxTaxe38Criteria) {
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
