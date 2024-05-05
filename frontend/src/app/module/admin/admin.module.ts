import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';

import { NotificationRetardDeuxiemeNivAdminModule } from './view/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiv-admin.module';
import { NotificationRetardDeuxiemeNivAdminRoutingModule } from './view/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiv-admin-routing.module';
import { NotificationRetardTroisiemeNivAdminModule } from './view/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiv-admin.module';
import { NotificationRetardTroisiemeNivAdminRoutingModule } from './view/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiv-admin-routing.module';
import { CommunAdminModule } from './view/commun/commun-admin.module';
import { CommunAdminRoutingModule } from './view/commun/commun-admin-routing.module';
import { NotificationPremierNivAdminModule } from './view/NotificationPremierNiv/NotificationPremierNiv-admin.module';
import { NotificationPremierNivAdminRoutingModule } from './view/NotificationPremierNiv/NotificationPremierNiv-admin-routing.module';
import { Taxe38AdminModule } from './view/taxe38/taxe38-admin.module';
import { Taxe38AdminRoutingModule } from './view/taxe38/taxe38-admin-routing.module';

import {SecurityModule} from 'src/app/module/security/security.module';
import {SecurityRoutingModule} from 'src/app/module/security/security-routing.module';
import { PageAcceuilComponent } from './view/page-acceuil/page-acceuil.component';


@NgModule({
  declarations: [
   LoginAdminComponent,
   RegisterAdminComponent,
   PageAcceuilComponent
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
  NotificationRetardDeuxiemeNivAdminModule,
  NotificationRetardDeuxiemeNivAdminRoutingModule,
  NotificationRetardTroisiemeNivAdminModule,
  NotificationRetardTroisiemeNivAdminRoutingModule,
  CommunAdminModule,
  CommunAdminRoutingModule,
  NotificationPremierNivAdminModule,
  NotificationPremierNivAdminRoutingModule,
  Taxe38AdminModule,
  Taxe38AdminRoutingModule,
  SecurityModule,
  SecurityRoutingModule
  ],
  exports: [
  LoginAdminComponent,
  RegisterAdminComponent,

    NotificationRetardDeuxiemeNivAdminModule,
    NotificationRetardTroisiemeNivAdminModule,
    CommunAdminModule,
    NotificationPremierNivAdminModule,
    Taxe38AdminModule,
  SecurityModule
  ],

})
export class AdminModule { }
