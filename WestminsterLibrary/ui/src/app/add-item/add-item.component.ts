import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";
import {Validator} from "@angular/forms";


@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  //declaring variables
  book: number  = 100;
  bookCount: string;
  bookTotal: number;
  bookISBN: string;
  bookTitle: string;
  bookSector: string;
  bookAuthor: string;
  bookPublisher: string;
  bookPublishedDate: string;
  bookNumberOfPage: string;

  dvd: number  = 50;
  dvdCount: string;
  dvdTotal: number;
  dvdISBN: string;
  dvdTitle: string;
  dvdSector: string;
  dvdLang: string;
  dvdSub: string;
  dvdProduser: string;
  dvdActor: string;
  messageBook: string = " can be added";
  messageDVD: string = " can be added";

  postRequestResponse1: string;
  postRequestResponse2: string;

  constructor(private appService: AppService) {

  }

  ngOnInit() {

    //checking dvd count
    this.appService.sendDData().subscribe((data: any) => {
      this.dvdCount = data.content;
      this.dvdTotal = this.dvd-parseInt(this.dvdCount);
    });

    //checking book count
    this.appService.sendBData().subscribe((data: any) => {
      this.bookCount = data.content;
      this.bookTotal = this.book-parseInt(this.bookCount);
    });

  }

  //when click on the add new book button data will be send to back end
  public saveNewBook(): void{
    if(this.bookTotal<=0){
      this.messageBook = "Can't be added";
    }else{
    if(this.bookISBN == null || this.bookTitle == null || this.bookSector == null || this.bookAuthor == null || this.bookPublisher == null || this.bookPublishedDate == null || this.bookNumberOfPage == null){
      this.postRequestResponse1 = "Please Fill All the Book details";
    }else{
    this.appService.sendBookData(this.bookISBN,this.bookTitle,this.bookSector,this.bookAuthor,this.bookPublisher,this.bookPublishedDate,this.bookNumberOfPage).subscribe((data: any) => {
      this.postRequestResponse1 = data.content;
    });}}
  }
  //when click on the add new DVD button data will be send to back end
  public saveNewDVD(): void{
    if(this.dvdTotal<=0){
      this.messageDVD = "Can't be added";
    }else{
    if(this.dvdISBN == null || this.dvdTitle == null || this.dvdSector == null || this.dvdLang == null || this.dvdSub == null || this.dvdProduser == null || this.dvdActor == null){
      this.postRequestResponse2 = "Please Fill All the DVD details";
    }else{
    this.appService.sendDVDData(this.dvdISBN,this.dvdTitle,this.dvdSector,this.dvdLang,this.dvdSub,this.dvdProduser,this.dvdActor).subscribe((data: any) => {
      this.postRequestResponse2 = data.content;
    });}}
  }
}
