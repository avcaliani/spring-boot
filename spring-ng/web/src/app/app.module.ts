import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OwnerImageComponent } from './owner/owner-image/owner-image.component';
import { OwnerContactComponent } from './owner/owner-contact/owner-contact.component';
import { OwnerDiscoverComponent } from './owner/owner-discover/owner-discover.component';

@NgModule({
  declarations: [
    AppComponent,
    OwnerImageComponent,
    OwnerContactComponent,
    OwnerDiscoverComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
