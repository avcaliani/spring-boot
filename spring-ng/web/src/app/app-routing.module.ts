import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OwnerDiscoverComponent } from './owner/owner-discover/owner-discover.component';
import { OwnerContactComponent } from './owner/owner-contact/owner-contact.component';

const routes: Routes = [
  { path: '', component: OwnerDiscoverComponent, pathMatch: 'full' },
  { path: 'contact', component: OwnerContactComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
