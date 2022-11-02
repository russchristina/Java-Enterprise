import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { HomepageComponent } from './components/pages/homepage/homepage.component';
import { LoginComponent } from './components/pages/login/login.component';

//For page navigation, Angular has a special module dedicated for this task known as the app-routing.module.ts file
//here we will define our routes (aka our URL paths to specific pages in our Angular) by declaring the path and its component in the Routes array below
const routes: Routes = [
  
  //declaring path url extension for http request and login component
  {path: 'login',
  component:LoginComponent},
  //declaring path url extension for http request and login component
  {path: 'homepage',
  component:HomepageComponent},

  //redirecting to login page when url extension is missing
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  //handling case when url extension is invalid
  {
    //* = wildcard for routes
    path: "**", 
    component: NotFoundComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
