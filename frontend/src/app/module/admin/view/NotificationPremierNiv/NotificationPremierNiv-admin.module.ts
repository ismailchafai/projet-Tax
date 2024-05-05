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

import { NotificationRetardPremierNiveauCreateAdminComponent } from './notification-retard-premier-niveau/create/notification-retard-premier-niveau-create-admin.component';
import { NotificationRetardPremierNiveauEditAdminComponent } from './notification-retard-premier-niveau/edit/notification-retard-premier-niveau-edit-admin.component';
import { NotificationRetardPremierNiveauViewAdminComponent } from './notification-retard-premier-niveau/view/notification-retard-premier-niveau-view-admin.component';
import { NotificationRetardPremierNiveauListAdminComponent } from './notification-retard-premier-niveau/list/notification-retard-premier-niveau-list-admin.component';

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

    NotificationRetardPremierNiveauCreateAdminComponent,
    NotificationRetardPremierNiveauListAdminComponent,
    NotificationRetardPremierNiveauViewAdminComponent,
    NotificationRetardPremierNiveauEditAdminComponent,
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
  NotificationRetardPremierNiveauCreateAdminComponent,
  NotificationRetardPremierNiveauListAdminComponent,
  NotificationRetardPremierNiveauViewAdminComponent,
  NotificationRetardPremierNiveauEditAdminComponent,
  ],
})
export class NotificationPremierNivAdminModule { }
