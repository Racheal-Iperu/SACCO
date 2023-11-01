import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { StudentRegistrationComponent } from './components/student-registration/student-registration.component';

@NgModule({
  declarations: [
    AppComponent,
    UserRegistrationComponent,
    NavBarComponent,
    StudentRegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
