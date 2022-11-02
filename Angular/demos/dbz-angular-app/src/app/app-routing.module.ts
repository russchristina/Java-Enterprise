import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './components/not-found/not-found.component';

//For page navigation, Angular has a special module dedicated for this task known as the app-routing.module.ts file
//here we will define our routes (aka our URL paths to specific pages in our Angular) by declaring the path and its component in the Routes array below
const routes: Routes = [
  {
    //* = wildcard for routes
    path: "404", 
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
