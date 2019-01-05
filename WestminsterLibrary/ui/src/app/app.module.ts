import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';
import { FormsModule }   from '@angular/forms';

import { AppComponent } from './app.component';
import { RouteExampleComponent } from './route-example/route-example.component';

import { AppService } from './app.service';
import { AppHttpInterceptorService } from './http-interceptor.service';
import { NavComponent } from './nav/nav.component';
import { AddItemComponent } from './add-item/add-item.component';
import { BorrowItemComponent } from './borrow-item/borrow-item.component';
import { DeleteItemComponent } from './delete-item/delete-item.component';
import { DiplayItemComponent } from './diplay-item/diplay-item.component';
import { GenrateItemComponent } from './genrate-item/genrate-item.component';
import { HomeComponent } from './home/home.component';
import {ReturnItemComponent} from "./return-item/return-item.component";
import { AddReaderComponent } from './add-reader/add-reader.component';

const routes: Routes = [

  {path: '',component: HomeComponent},
  {path: 'add-item',component: AddItemComponent},
  {path: 'delete-item',component: DeleteItemComponent},
  {path: 'display-item',component: DiplayItemComponent},
  {path: 'borrow-item',component: BorrowItemComponent},
  {path: 'return-item',component: ReturnItemComponent},
  {path: 'generate-report',component: GenrateItemComponent},
  {path: 'add-reader',component: AddReaderComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    RouteExampleComponent,
    NavComponent,
    AddItemComponent,
    BorrowItemComponent,
    DeleteItemComponent,
    DiplayItemComponent,
    GenrateItemComponent,
    ReturnItemComponent,
    HomeComponent,
    AddReaderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    RouterModule.forRoot(routes)
  ],
  providers: [
    AppService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
