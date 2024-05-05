import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { LayoutService } from './service/app.layout.service';
import {RoleService} from "../zynerator/security/shared/service/Role.service";
import {AppComponent} from "../app.component";
import {AuthService} from "../zynerator/security/shared/service/Auth.service";
import {Router} from "@angular/router";
import {AppLayoutComponent} from "./app.layout.component";

@Component({
  selector: 'app-menu',
  templateUrl: './app.menu.component.html'
})
export class AppMenuComponent implements OnInit {
  model: any[];
  modelanonymous: any[];
    modelAdmin: any[];
constructor(public layoutService: LayoutService, public app: AppComponent, public appMain: AppLayoutComponent, private roleService: RoleService, private authService: AuthService, private router: Router) { }
  ngOnInit() {
    this.modelAdmin =
      [

				{
                    label: 'Pages',
                    icon: 'pi pi-fw pi-briefcase',
                    items: [
					  {
						label: 'Rue',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste rue',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/rue/list']
								  },
						]
					  },
					  {
						label: 'TypeLocale38Detail',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste type locale38 detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/taxe38/type-locale38-detail/list']
								  },
						]
					  },
					  {
						label: 'Trim',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste trim',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/taxe38/trim/list']
								  },
						]
					  },
					  {
						label: 'NotificationRetardPremierNiveau',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste notification retard premier niveau',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/NotificationPremierNiv/notification-retard-premier-niveau/list']
								  },
						]
					  },
					  {
						label: 'Redevabl',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste locale',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/locale/list']
								  },
						]
					  },
					  {
						label: 'Redevable',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste redevable',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/redevable/list']
								  },
						]
					  },
					  {
						label: 'Quartier',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste quartier',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/quartier/list']
								  },
						]
					  },
					  {
						label: 'TauxTaxe38',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste taux taxe38',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/taxe38/taux-taxe38/list']
								  },
						]
					  },
					  {
						label: 'NotificationRetardTroisiemeNiveau',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste notification retard troisieme niveau',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/NotificationRetardTroisiemeNiv/notification-retard-troisieme-niveau/list']
								  },
						]
					  },
					  {
						label: 'Locale38Detail',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste locale38 detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/taxe38/locale38-detail/list']
								  },
						]
					  },
					  {
						label: 'NotificationRetardDeuxiemeNiveau',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste notification retard deuxieme niveau',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/NotificationRetardDeuxiemeNiv/notification-retard-deuxieme-niveau/list']
								  },
								  {
									label: 'Liste notification retard deuxieme niveau detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/NotificationRetardDeuxiemeNiv/notification-retard-deuxieme-niveau-detail/list']
								  },
								  {
									label: 'Liste notification retard deuxieme niveau detail type38',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/NotificationRetardDeuxiemeNiv/notification-retard-deuxieme-niveau-detail-type38/list']
								  },
						]
					  },
					  {
						label: 'Taxe38Detail',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste taxe38 detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/taxe38/taxe38-detail/list']
								  },
						]
					  },
					  {
						label: 'Secteur',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste secteur',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/secteur/list']
								  },
						]
					  },
					  {
						label: 'Taxe38',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste categorie locale',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/taxe38/categorie-locale/list']
								  },
								  {
									label: 'Liste taxe38',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/taxe38/taxe38/list']
								  },
						]
					  },
					  {
						label: 'Ville',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste ville',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/ville/list']
								  },
						]
					  },

				   {
					  label: 'Security Management',
					  icon: 'pi pi-wallet',
					  items: [
						  {
							  label: 'List User',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/user/list']
						  },
						  {
							  label: 'List Model',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/model-permission/list']
						  },
						  {
							  label: 'List Action Permission',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/action-permission/list']
						  },
					  ]
				  }
			]
	    }
    ];

        if (this.authService.authenticated) {
            if (this.authService.authenticatedUser.roleUsers) {
              this.authService.authenticatedUser.roleUsers.forEach(role => {
                  const roleName: string = this.getRole(role.role.authority);
                  this.roleService._role.next(roleName.toUpperCase());
                  eval('this.model = this.model' + this.getRole(role.role.authority));
              })
            }
        }
  }

    getRole(text){
        const [role, ...rest] = text.split('_');
        return this.upperCaseFirstLetter(rest.join(''));
    }

    upperCaseFirstLetter(word: string) {
      if (!word) { return word; }
      return word[0].toUpperCase() + word.substr(1).toLowerCase();
    }

    onMenuClick(event) {
        this.appMain.onMenuClick(event);
    }
}
