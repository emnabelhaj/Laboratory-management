import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MembreListComponent } from './membre-list/membre-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { MemberFormComponent } from './member-form/member-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ConfirmDialogModule } from './confirm-dialog.module';
import { LayoutComponent } from './layout/layout.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ArtilcesComponent } from './artilces/artilces.component';
import { FirebaseModule } from './firebase/firebase.module';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { ArticleFormComponent } from './article-form/article-form.component';
import { OutilListComponent } from './outil-list/outil-list.component';
import { OutilFormComponent } from './outil-form/outil-form.component';
import { EventFormComponent } from './event-form/event-form.component';
import { EventListComponent } from './event-list/event-list.component';



@NgModule({
  declarations: [
    AppComponent,
    MembreListComponent,
    MemberFormComponent,
    LayoutComponent,
    DashboardComponent,
    ArtilcesComponent,
    LoginComponent,
    ArticleFormComponent,
    OutilListComponent,
    OutilFormComponent,
    EventFormComponent,
    EventListComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FirebaseModule,
    MaterialModule,
    FlexLayoutModule, HttpClientModule,
    ConfirmDialogModule



  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
