import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-return-item',
  templateUrl: './return-item.component.html',
  styleUrls: ['./return-item.component.css']
})
export class ReturnItemComponent implements OnInit {

  //Declaring variables
  rISBN: string;
  rDate: string;
  rTime: string;

  postRequestResponse: string;

  constructor(private appService: AppService) { }

  ngOnInit() {
  }

  //method for send and get return item details
  public returnItem(): void{
    if(this.rISBN == null || this.rDate == null || this.rTime == null){
      this.postRequestResponse = "Please fill all fields";
    }else{
    this.appService.returnItem(this.rISBN,this.rDate,this.rTime).subscribe((data: any) => {
      this.postRequestResponse = data.content;
    });}
  }
}
