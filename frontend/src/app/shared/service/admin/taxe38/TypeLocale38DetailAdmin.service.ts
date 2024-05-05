import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import * as moment from 'moment/moment';

import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailCriteria} from 'src/app/shared/criteria/taxe38/TypeLocale38DetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TypeLocale38DetailAdminService {
    protected _API = '';
    protected _items: Array<TypeLocale38DetailDto>;
    protected _item: TypeLocale38DetailDto;
    protected _selections: Array<TypeLocale38DetailDto>;
    protected _createDialog: boolean;
    protected _editDialog: boolean;
    protected _viewDialog: boolean;
    protected _criteria: TypeLocale38DetailCriteria;
    protected _validate = false;

    private _createActionIsValid = true;
    private _editActionIsValid = true;
    private _listActionIsValid = true;
    private _deleteActionIsValid = true;
    private _viewActionIsValid = true;
    private _duplicateActionIsValid = true;


    private _createAction = 'create';
    private _listAction = 'list';
    private _editAction = 'edit';
    private _deleteAction = 'delete';
    private _viewAction = 'view';
    private _duplicateAction = 'duplicate';
    private _entityName: string;

    protected API_PERMISSION: string ;


    constructor(private http: HttpClient) {
        this.API_PERMISSION = environment.apiUrl + 'modelPermissionUser/';
    }


    public findAll() {
        return this.http.get<Array<TypeLocale38DetailDto>>(this.API);
    }

    public findAllOptimized() {
        return this.http.get<Array<TypeLocale38DetailDto>>(this.API + 'optimized');
    }

    public findPaginatedByCriteria(criteria: TypeLocale38DetailCriteria): Observable<PaginatedList<TypeLocale38DetailDto>> {
        return this.http.post<PaginatedList<TypeLocale38DetailDto>>(this.API + 'find-paginated-by-criteria', criteria);
    }

    public save(): Observable<TypeLocale38DetailDto> {
        return this.http.post<TypeLocale38DetailDto>(this.API, this.item);
    }

    public delete(dto: TypeLocale38DetailDto) {
        return this.http.delete<number>(this.API + 'id/' + dto.id);
    }


    public edit(): Observable<TypeLocale38DetailDto> {
        return this.http.put<TypeLocale38DetailDto>(this.API, this.item);
    }


    public findByCriteria(criteria: TypeLocale38DetailCriteria): Observable<Array<TypeLocale38DetailDto>> {
        return this.http.post<Array<TypeLocale38DetailDto>>(this.API + 'find-by-criteria', criteria);
    }

    public findByIdWithAssociatedList(item: TypeLocale38DetailDto): Observable<TypeLocale38DetailDto> {
        return this.http.get<TypeLocale38DetailDto>(this.API + 'id/' + item.id);
    }

    public deleteMultiple() {
        return this.http.post<void>(this.API + 'multiple', this.selections);
    }
    public exportPdf(element: TypeLocale38DetailDto): Observable<ArrayBuffer> {
        return this.http.post(this.API + 'exportPdf/', element, {responseType: 'arraybuffer'});
    }

    public hasActionPermission(username: string, actionReference: string): Observable<boolean> {
        // tslint:disable-next-line:max-line-length
        return this.http.get<boolean>(this.API_PERMISSION + 'user/' + username + '/model/' + this.entityName + '/action/' + actionReference);
    }

    public importExcel(file: File): Observable<Array<TypeLocale38DetailDto>> {
        const formData: FormData = new FormData();
        formData.append('file', file, file.name);
        return this.http.post<Array<TypeLocale38DetailDto>>(this.API + 'import-excel', formData);
    }



    public format(myDate: Date): Date {
        if (myDate != null) {
            const newdate = new Date(myDate);
            const formattedDate = moment(newdate).format(environment.dateFormatEdit);
            console.log(formattedDate);
            myDate = new Date(formattedDate);
        }
        return myDate;
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/typeLocale38Detail/';
    }

    public get items(): Array<TypeLocale38DetailDto> {
        if (this._items == null) {
            this._items = new Array<TypeLocale38DetailDto>();
        }
        return this._items;
    }

    public set items(value: Array<TypeLocale38DetailDto>) {
        this._items = value;
    }

    public get item(): TypeLocale38DetailDto {
        if (this._item == null) {
            this._item = new TypeLocale38DetailDto();
        }
        return this._item;
    }

    public set item(value: TypeLocale38DetailDto) {
        this._item = value;
    }

    public get selections(): Array<TypeLocale38DetailDto> {
        if (this._selections == null) {
            this._selections = new Array<TypeLocale38DetailDto>();
        }
        return this._selections;
    }


    public set selections(value: Array<TypeLocale38DetailDto>) {
        this._selections = value;
    }

    public get createDialog(): boolean {
        return this._createDialog;
    }

    public set createDialog(value: boolean) {
        this._createDialog = value;
    }

    public get editDialog(): boolean {
        return this._editDialog;
    }

    public set editDialog(value: boolean) {
        this._editDialog = value;
    }

    public get viewDialog(): boolean {
        return this._viewDialog;
    }

    public set viewDialog(value: boolean) {
        this._viewDialog = value;
    }

    public get criteria(): TypeLocale38DetailCriteria {
        if (this._criteria == null) {
            this._criteria = new TypeLocale38DetailCriteria();
        }
        return this._criteria;
    }

    public set criteria(value: TypeLocale38DetailCriteria) {
        this._criteria = value;
    }


    public setApi(API: string) {
        this._API = API;
    }

    set validate(value: boolean) {
        this._validate = value;
    }


    get createAction(): string {
        return this._createAction;
    }

    set createAction(value: string) {
        this._createAction = value;
    }

    get listAction(): string {
        return this._listAction;
    }

    set listAction(value: string) {
        this._listAction = value;
    }

    get editAction(): string {
        return this._editAction;
    }

    set editAction(value: string) {
        this._editAction = value;
    }

    get deleteAction(): string {
        return this._deleteAction;
    }

    set deleteAction(value: string) {
        this._deleteAction = value;
    }

    get createActionIsValid(): boolean {
        return this._createActionIsValid;
    }

    set createActionIsValid(value: boolean) {
        this._createActionIsValid = value;
    }


    get editActionIsValid(): boolean {
        return this._editActionIsValid;
    }

    set editActionIsValid(value: boolean) {
        this._editActionIsValid = value;
    }

    get listActionIsValid(): boolean {
        return this._listActionIsValid;
    }

    set listActionIsValid(value: boolean) {
        this._listActionIsValid = value;
    }

    get deleteActionIsValid(): boolean {
        return this._deleteActionIsValid;
    }

    set deleteActionIsValid(value: boolean) {
        this._deleteActionIsValid = value;
    }

    get viewAction(): string {
        return this._viewAction;
    }

    set viewAction(value: string) {
        this._viewAction = value;
    }

    get duplicateAction(): string {
        return this._duplicateAction;
    }

    set duplicateAction(value: string) {
        this._duplicateAction = value;
    }

    get viewActionIsValid(): boolean {
        return this._viewActionIsValid;
    }

    set viewActionIsValid(value: boolean) {
        this._viewActionIsValid = value;
    }

    get duplicateActionIsValid(): boolean {
        return this._duplicateActionIsValid;
    }

    set duplicateActionIsValid(value: boolean) {
        this._duplicateActionIsValid = value;
    }

    get entityName(): string {
        return this._entityName;
    }

    set entityName(value: string) {
        this._entityName = value;
    }

}
