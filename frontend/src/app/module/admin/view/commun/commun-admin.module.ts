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

import { RueCreateAdminComponent } from './rue/create/rue-create-admin.component';
import { RueEditAdminComponent } from './rue/edit/rue-edit-admin.component';
import { RueViewAdminComponent } from './rue/view/rue-view-admin.component';
import { RueListAdminComponent } from './rue/list/rue-list-admin.component';
import { VilleCreateAdminComponent } from './ville/create/ville-create-admin.component';
import { VilleEditAdminComponent } from './ville/edit/ville-edit-admin.component';
import { VilleViewAdminComponent } from './ville/view/ville-view-admin.component';
import { VilleListAdminComponent } from './ville/list/ville-list-admin.component';
import { SecteurCreateAdminComponent } from './secteur/create/secteur-create-admin.component';
import { SecteurEditAdminComponent } from './secteur/edit/secteur-edit-admin.component';
import { SecteurViewAdminComponent } from './secteur/view/secteur-view-admin.component';
import { SecteurListAdminComponent } from './secteur/list/secteur-list-admin.component';
import { LocaleCreateAdminComponent } from './locale/create/locale-create-admin.component';
import { LocaleEditAdminComponent } from './locale/edit/locale-edit-admin.component';
import { LocaleViewAdminComponent } from './locale/view/locale-view-admin.component';
import { LocaleListAdminComponent } from './locale/list/locale-list-admin.component';
import { RedevableCreateAdminComponent } from './redevable/create/redevable-create-admin.component';
import { RedevableEditAdminComponent } from './redevable/edit/redevable-edit-admin.component';
import { RedevableViewAdminComponent } from './redevable/view/redevable-view-admin.component';
import { RedevableListAdminComponent } from './redevable/list/redevable-list-admin.component';
import { QuartierCreateAdminComponent } from './quartier/create/quartier-create-admin.component';
import { QuartierEditAdminComponent } from './quartier/edit/quartier-edit-admin.component';
import { QuartierViewAdminComponent } from './quartier/view/quartier-view-admin.component';
import { QuartierListAdminComponent } from './quartier/list/quartier-list-admin.component';

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

    RueCreateAdminComponent,
    RueListAdminComponent,
    RueViewAdminComponent,
    RueEditAdminComponent,
    VilleCreateAdminComponent,
    VilleListAdminComponent,
    VilleViewAdminComponent,
    VilleEditAdminComponent,
    SecteurCreateAdminComponent,
    SecteurListAdminComponent,
    SecteurViewAdminComponent,
    SecteurEditAdminComponent,
    LocaleCreateAdminComponent,
    LocaleListAdminComponent,
    LocaleViewAdminComponent,
    LocaleEditAdminComponent,
    RedevableCreateAdminComponent,
    RedevableListAdminComponent,
    RedevableViewAdminComponent,
    RedevableEditAdminComponent,
    QuartierCreateAdminComponent,
    QuartierListAdminComponent,
    QuartierViewAdminComponent,
    QuartierEditAdminComponent,
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
  RueCreateAdminComponent,
  RueListAdminComponent,
  RueViewAdminComponent,
  RueEditAdminComponent,
  VilleCreateAdminComponent,
  VilleListAdminComponent,
  VilleViewAdminComponent,
  VilleEditAdminComponent,
  SecteurCreateAdminComponent,
  SecteurListAdminComponent,
  SecteurViewAdminComponent,
  SecteurEditAdminComponent,
  LocaleCreateAdminComponent,
  LocaleListAdminComponent,
  LocaleViewAdminComponent,
  LocaleEditAdminComponent,
  RedevableCreateAdminComponent,
  RedevableListAdminComponent,
  RedevableViewAdminComponent,
  RedevableEditAdminComponent,
  QuartierCreateAdminComponent,
  QuartierListAdminComponent,
  QuartierViewAdminComponent,
  QuartierEditAdminComponent,
  ],
})
export class CommunAdminModule { }
