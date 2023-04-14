import { Routes } from '@angular/router';

import { DashboardComponent } from '../../dashboard/dashboard.component';
import { UserProfileComponent } from '../../user-profile/user-profile.component';
import { TableListComponent } from '../../table-list/table-list.component';

import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';


export const AdminLayoutRoutes: Routes = [
    { path: 'equipe',      component: DashboardComponent },
    { path: 'pari',   component: UserProfileComponent },
    { path: 'sport',     component: TableListComponent },

    { path: 'joueur',          component: IconsComponent },
    { path: 'match',           component: MapsComponent },
    { path: 'parieur',  component: NotificationsComponent }
    
];
