
// const root = environment.rootAppUrl;



import {UserListComponent} from 'src/app/module/security/user/list/user-list.component';
import {ModelPermissionListComponent} from 'src/app/module/security/model-permission/list/model-permission-list.component';
import {ActionPermissionListComponent} from 'src/app/module/security/action-permission/list/action-permission-list.component';
import {ModelPermissionUserListComponent} from 'src/app/module/security/model-permission-utilisateur/list/model-permission-user-list.component';
import {RoleListComponent} from 'src/app/module/security/role/list/role-list.component';



import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {AuthGuard} from 'src/app/zynerator/security/guards/auth.guard';



import { TrimListAdminComponent } from './trim/list/trim-list-admin.component';
import { CategorieLocaleListAdminComponent } from './categorie-locale/list/categorie-locale-list-admin.component';
import { TypeLocale38DetailListAdminComponent } from './type-locale38-detail/list/type-locale38-detail-list-admin.component';
import { Locale38DetailListAdminComponent } from './locale38-detail/list/locale38-detail-list-admin.component';
import { Taxe38DetailListAdminComponent } from './taxe38-detail/list/taxe38-detail-list-admin.component';
import { Taxe38ListAdminComponent } from './taxe38/list/taxe38-list-admin.component';
import { TauxTaxe38ListAdminComponent } from './taux-taxe38/list/taux-taxe38-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [
                        {

                            path: 'action-permission',
                            children: [
                                {
                                    path: 'list',
                                    component: ActionPermissionListComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'model-permission-user',
                            children: [
                                {
                                    path: 'list',
                                    component: ModelPermissionUserListComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },
                        {

                            path: 'role',
                            children: [
                                {
                                    path: 'list',
                                    component: RoleListComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },
                        {

                            path: 'user',
                            children: [
                                {
                                    path: 'list',
                                    component: UserListComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'model-permission',
                            children: [
                                {
                                    path: 'list',
                                    component: ModelPermissionListComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },


                        {

                            path: 'trim',
                            children: [
                                {
                                    path: 'list',
                                    component: TrimListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'categorie-locale',
                            children: [
                                {
                                    path: 'list',
                                    component: CategorieLocaleListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'type-locale38-detail',
                            children: [
                                {
                                    path: 'list',
                                    component: TypeLocale38DetailListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'locale38-detail',
                            children: [
                                {
                                    path: 'list',
                                    component: Locale38DetailListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'taxe38-detail',
                            children: [
                                {
                                    path: 'list',
                                    component: Taxe38DetailListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'taxe38',
                            children: [
                                {
                                    path: 'list',
                                    component: Taxe38ListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'taux-taxe38',
                            children: [
                                {
                                    path: 'list',
                                    component: TauxTaxe38ListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class Taxe38AdminRoutingModule { }
