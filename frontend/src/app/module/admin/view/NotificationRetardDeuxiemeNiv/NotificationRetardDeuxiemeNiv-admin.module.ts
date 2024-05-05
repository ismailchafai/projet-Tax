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

import { NotificationRetardDeuxiemeNiveauCreateAdminComponent } from './notification-retard-deuxieme-niveau/create/notification-retard-deuxieme-niveau-create-admin.component';
import { NotificationRetardDeuxiemeNiveauEditAdminComponent } from './notification-retard-deuxieme-niveau/edit/notification-retard-deuxieme-niveau-edit-admin.component';
import { NotificationRetardDeuxiemeNiveauViewAdminComponent } from './notification-retard-deuxieme-niveau/view/notification-retard-deuxieme-niveau-view-admin.component';
import { NotificationRetardDeuxiemeNiveauListAdminComponent } from './notification-retard-deuxieme-niveau/list/notification-retard-deuxieme-niveau-list-admin.component';
import { NotificationRetardDeuxiemeNiveauDetailCreateAdminComponent } from './notification-retard-deuxieme-niveau-detail/create/notification-retard-deuxieme-niveau-detail-create-admin.component';
import { NotificationRetardDeuxiemeNiveauDetailEditAdminComponent } from './notification-retard-deuxieme-niveau-detail/edit/notification-retard-deuxieme-niveau-detail-edit-admin.component';
import { NotificationRetardDeuxiemeNiveauDetailViewAdminComponent } from './notification-retard-deuxieme-niveau-detail/view/notification-retard-deuxieme-niveau-detail-view-admin.component';
import { NotificationRetardDeuxiemeNiveauDetailListAdminComponent } from './notification-retard-deuxieme-niveau-detail/list/notification-retard-deuxieme-niveau-detail-list-admin.component';
import { NotificationRetardDeuxiemeNiveauDetailType38CreateAdminComponent } from './notification-retard-deuxieme-niveau-detail-type38/create/notification-retard-deuxieme-niveau-detail-type38-create-admin.component';
import { NotificationRetardDeuxiemeNiveauDetailType38EditAdminComponent } from './notification-retard-deuxieme-niveau-detail-type38/edit/notification-retard-deuxieme-niveau-detail-type38-edit-admin.component';
import { NotificationRetardDeuxiemeNiveauDetailType38ViewAdminComponent } from './notification-retard-deuxieme-niveau-detail-type38/view/notification-retard-deuxieme-niveau-detail-type38-view-admin.component';
import { NotificationRetardDeuxiemeNiveauDetailType38ListAdminComponent } from './notification-retard-deuxieme-niveau-detail-type38/list/notification-retard-deuxieme-niveau-detail-type38-list-admin.component';

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

    NotificationRetardDeuxiemeNiveauCreateAdminComponent,
    NotificationRetardDeuxiemeNiveauListAdminComponent,
    NotificationRetardDeuxiemeNiveauViewAdminComponent,
    NotificationRetardDeuxiemeNiveauEditAdminComponent,
    NotificationRetardDeuxiemeNiveauDetailCreateAdminComponent,
    NotificationRetardDeuxiemeNiveauDetailListAdminComponent,
    NotificationRetardDeuxiemeNiveauDetailViewAdminComponent,
    NotificationRetardDeuxiemeNiveauDetailEditAdminComponent,
    NotificationRetardDeuxiemeNiveauDetailType38CreateAdminComponent,
    NotificationRetardDeuxiemeNiveauDetailType38ListAdminComponent,
    NotificationRetardDeuxiemeNiveauDetailType38ViewAdminComponent,
    NotificationRetardDeuxiemeNiveauDetailType38EditAdminComponent,
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
  NotificationRetardDeuxiemeNiveauCreateAdminComponent,
  NotificationRetardDeuxiemeNiveauListAdminComponent,
  NotificationRetardDeuxiemeNiveauViewAdminComponent,
  NotificationRetardDeuxiemeNiveauEditAdminComponent,
  NotificationRetardDeuxiemeNiveauDetailCreateAdminComponent,
  NotificationRetardDeuxiemeNiveauDetailListAdminComponent,
  NotificationRetardDeuxiemeNiveauDetailViewAdminComponent,
  NotificationRetardDeuxiemeNiveauDetailEditAdminComponent,
  NotificationRetardDeuxiemeNiveauDetailType38CreateAdminComponent,
  NotificationRetardDeuxiemeNiveauDetailType38ListAdminComponent,
  NotificationRetardDeuxiemeNiveauDetailType38ViewAdminComponent,
  NotificationRetardDeuxiemeNiveauDetailType38EditAdminComponent,
  ],
})
export class NotificationRetardDeuxiemeNivAdminModule { }
