import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-borrow-item',
  templateUrl: './borrow-item.component.html',
  styleUrls: ['./borrow-item.component.css']
})
export class BorrowItemComponent implements OnInit {

  //Declaring variables
  bBookISBN: string;
  bBReaderName: string;
  bBDate: string;
  bBookTime: string;

  bDVDISBN: string;
  bDReaderName: string;
  bDDate: string;
  bDVDTime: string;

  postRequestResponseBook: string;
  postRequestResponseDVD: string;

  constructor(private appService: AppService) { }

  ngOnInit() {
  }
  //Method for pass entered borrow book data to back end and get respond from back end
  public borrowBook(): void{
    if(this.bBookISBN == null || this.bBReaderName == null || this.bBDate == null || this.bBookTime == null){
      this.postRequestResponseBook = "Please Fill all the details";
    }else{
      this.appService.sendBorrowBookData(this.bBookISBN,this.bBReaderName,this.bBDate,this.bBookTime).subscribe((data: any) => {
      this.postRequestResponseBook = data.content;
    });}
  }

  //Method for pass entered borrow book data to back end and get respond from back end
  public borrowDVD(): void{
    if(this.bDVDTime == null || this.bDVDISBN == null || this.bDReaderName == null || this.bDDate == null) {
      this.postRequestResponseDVD = "Please Fill all the details";
    }else{
      this.appService.sendBorrowDVDData(this.bDVDISBN,this.bDReaderName,this.bDDate,this.bDVDTime).subscribe((data: any) => {
      this.postRequestResponseDVD = data.content;
    });}
  }
}
