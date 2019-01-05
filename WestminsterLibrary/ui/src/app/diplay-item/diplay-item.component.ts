import { Component, OnInit } from '@angular/core';
import {AppService} from "src/app/app.service";
/*import {FormGroup} from "@angular/forms";
import { FormGroup} from '@angular/forms';*/

@Component({
  selector: 'app-diplay-item',
  templateUrl: './diplay-item.component.html',
  styleUrls: ['./diplay-item.component.css']
})
export class DiplayItemComponent implements OnInit {


  //Declaring variables
  private getBookDetails = '/api/displayBook';
  private getDVDDetails = '/api/displayDVD';

  search: string;
  bookDetails: any;
  dvdDetails: any;
  postRequestResponse: string;
  Available: string = "Available";

  constructor(private appService: AppService) { }

  ngOnInit() {
    //displaying books
    this.appService.displayBook(this.getBookDetails).subscribe((data: any) => {
      this.bookDetails = data;
    });

    //displaying dvd
    this.appService.displayDVD(this.getDVDDetails).subscribe((data: any) => {
      this.dvdDetails = data;
    });
  }

  //method for pass search details to back end and get respond from from back end
  public searchMethod(): void{
    if(this.search == null){
      this.postRequestResponse = "Please Enter Title";
    }else{
      this.appService.sendSearchData(this.search).subscribe((data: any) => {
        this.postRequestResponse = data.content;
      });}
  }

}
