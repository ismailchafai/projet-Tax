import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {EditorModule} from "primeng/editor";

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';
import {CardModule} from "primeng/card";

import { TrimCreateAdminComponent } from './trim/create/trim-create-admin.component';
import { TrimEditAdminComponent } from './trim/edit/trim-edit-admin.component';
import { TrimViewAdminComponent } from './trim/view/trim-view-admin.component';
import { TrimListAdminComponent } from './trim/list/trim-list-admin.component';
import { CategorieLocaleCreateAdminComponent } from './categorie-locale/create/categorie-locale-create-admin.component';
import { CategorieLocaleEditAdminComponent } from './categorie-locale/edit/categorie-locale-edit-admin.component';
import { CategorieLocaleViewAdminComponent } from './categorie-locale/view/categorie-locale-view-admin.component';
import { CategorieLocaleListAdminComponent } from './categorie-locale/list/categorie-locale-list-admin.component';
import { TypeLocale38DetailCreateAdminComponent } from './type-locale38-detail/create/type-locale38-detail-create-admin.component';
import { TypeLocale38DetailEditAdminComponent } from './type-locale38-detail/edit/type-locale38-detail-edit-admin.component';
import { TypeLocale38DetailViewAdminComponent } from './type-locale38-detail/view/type-locale38-detail-view-admin.component';
import { TypeLocale38DetailListAdminComponent } from './type-locale38-detail/list/type-locale38-detail-list-admin.component';
import { Locale38DetailCreateAdminComponent } from './locale38-detail/create/locale38-detail-create-admin.component';
import { Locale38DetailEditAdminComponent } from './locale38-detail/edit/locale38-detail-edit-admin.component';
import { Locale38DetailViewAdminComponent } from './locale38-detail/view/locale38-detail-view-admin.component';
import { Locale38DetailListAdminComponent } from './locale38-detail/list/locale38-detail-list-admin.component';
import { Taxe38DetailCreateAdminComponent } from './taxe38-detail/create/taxe38-detail-create-admin.component';
import { Taxe38DetailEditAdminComponent } from './taxe38-detail/edit/taxe38-detail-edit-admin.component';
import { Taxe38DetailViewAdminComponent } from './taxe38-detail/view/taxe38-detail-view-admin.component';
import { Taxe38DetailListAdminComponent } from './taxe38-detail/list/taxe38-detail-list-admin.component';
import { Taxe38CreateAdminComponent } from './taxe38/create/taxe38-create-admin.component';
import { Taxe38EditAdminComponent } from './taxe38/edit/taxe38-edit-admin.component';
import { Taxe38ViewAdminComponent } from './taxe38/view/taxe38-view-admin.component';
import { Taxe38ListAdminComponent } from './taxe38/list/taxe38-list-admin.component';
import { TauxTaxe38CreateAdminComponent } from './taux-taxe38/create/taux-taxe38-create-admin.component';
import { TauxTaxe38EditAdminComponent } from './taux-taxe38/edit/taux-taxe38-edit-admin.component';
import { TauxTaxe38ViewAdminComponent } from './taux-taxe38/view/taux-taxe38-view-admin.component';
import { TauxTaxe38ListAdminComponent } from './taux-taxe38/list/taux-taxe38-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    TrimCreateAdminComponent,
    TrimListAdminComponent,
    TrimViewAdminComponent,
    TrimEditAdminComponent,
    CategorieLocaleCreateAdminComponent,
    CategorieLocaleListAdminComponent,
    CategorieLocaleViewAdminComponent,
    CategorieLocaleEditAdminComponent,
    TypeLocale38DetailCreateAdminComponent,
    TypeLocale38DetailListAdminComponent,
    TypeLocale38DetailViewAdminComponent,
    TypeLocale38DetailEditAdminComponent,
    Locale38DetailCreateAdminComponent,
    Locale38DetailListAdminComponent,
    Locale38DetailViewAdminComponent,
    Locale38DetailEditAdminComponent,
    Taxe38DetailCreateAdminComponent,
    Taxe38DetailListAdminComponent,
    Taxe38DetailViewAdminComponent,
    Taxe38DetailEditAdminComponent,
    Taxe38CreateAdminComponent,
    Taxe38ListAdminComponent,
    Taxe38ViewAdminComponent,
    Taxe38EditAdminComponent,
    TauxTaxe38CreateAdminComponent,
    TauxTaxe38ListAdminComponent,
    TauxTaxe38ViewAdminComponent,
    TauxTaxe38EditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,
    CardModule,
    EditorModule,


  ],
  exports: [
  TrimCreateAdminComponent,
  TrimListAdminComponent,
  TrimViewAdminComponent,
  TrimEditAdminComponent,
  CategorieLocaleCreateAdminComponent,
  CategorieLocaleListAdminComponent,
  CategorieLocaleViewAdminComponent,
  CategorieLocaleEditAdminComponent,
  TypeLocale38DetailCreateAdminComponent,
  TypeLocale38DetailListAdminComponent,
  TypeLocale38DetailViewAdminComponent,
  TypeLocale38DetailEditAdminComponent,
  Locale38DetailCreateAdminComponent,
  Locale38DetailListAdminComponent,
  Locale38DetailViewAdminComponent,
  Locale38DetailEditAdminComponent,
  Taxe38DetailCreateAdminComponent,
  Taxe38DetailListAdminComponent,
  Taxe38DetailViewAdminComponent,
  Taxe38DetailEditAdminComponent,
  Taxe38CreateAdminComponent,
  Taxe38ListAdminComponent,
  Taxe38ViewAdminComponent,
  Taxe38EditAdminComponent,
  TauxTaxe38CreateAdminComponent,
  TauxTaxe38ListAdminComponent,
  TauxTaxe38ViewAdminComponent,
  TauxTaxe38EditAdminComponent,
  ],
})
export class Taxe38AdminModule { }
