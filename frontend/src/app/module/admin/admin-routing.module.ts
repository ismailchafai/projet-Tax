
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {AuthGuard} from 'src/app/zynerator/security/guards/auth.guard';

import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';

@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [
                        {
                            path: 'login',
                            children: [
                                {
                                    path: '',
                                    component: LoginAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {
                            path: 'register',
                            children: [
                                {
                                    path: '',
                                    component: RegisterAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {
                            path: 'NotificationRetardDeuxiemeNiv',
                            loadChildren: () => import('./view/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiv-admin-routing.module').then(x => x.NotificationRetardDeuxiemeNivAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {
                            path: 'NotificationRetardTroisiemeNiv',
                            loadChildren: () => import('./view/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiv-admin-routing.module').then(x => x.NotificationRetardTroisiemeNivAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {
                            path: 'commun',
                            loadChildren: () => import('./view/commun/commun-admin-routing.module').then(x => x.CommunAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {
                            path: 'NotificationPremierNiv',
                            loadChildren: () => import('./view/NotificationPremierNiv/NotificationPremierNiv-admin-routing.module').then(x => x.NotificationPremierNivAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {
                            path: 'taxe38',
                            loadChildren: () => import('./view/taxe38/taxe38-admin-routing.module').then(x => x.Taxe38AdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {
                            path: 'security',
                            loadChildren: () => import('../security/security-routing.module').then(x => x.SecurityRoutingModule),
                            canActivate: [AuthGuard],
                        }
                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class AdminRoutingModule { }
