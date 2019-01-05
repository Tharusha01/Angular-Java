import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-add-reader',
  templateUrl: './add-reader.component.html',
  styleUrls: ['./add-reader.component.css']
})
export class AddReaderComponent implements OnInit {

  //Declaring variables
  readerId: string;
  readerName: string;
  readerMobile: string;
  readerEmail: string;

  postRequestResponse: string;

  constructor(private appService: AppService) { }

  ngOnInit() {
  }
  //method for pass entered reader details to back end
  public addReader(): void{
    if(this.readerId == null || this.readerName == null || this.readerMobile == null || this.readerEmail == null){
      this.postRequestResponse = "Please Fill all the Details";
    }else{
    this.appService.sendReaderData(this.readerId,this.readerName,this.readerMobile,this.readerEmail).subscribe((data: any) => {
      this.postRequestResponse = data.content;
    });}
  }

}
