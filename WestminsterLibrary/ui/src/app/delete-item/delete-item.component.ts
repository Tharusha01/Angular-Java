import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-delete-item',
  templateUrl: './delete-item.component.html',
  styleUrls: ['./delete-item.component.css']
})
export class DeleteItemComponent implements OnInit {

  //Declaring variables
  deleteISBN: string;

  postRequestResponse: string;

  constructor(private appService: AppService) { }

  ngOnInit() {
  }

  //method for send delete details to back end and get respond from front end
  public deleteItem(): void{
    if(this.deleteISBN == null){
      this.postRequestResponse = "Please enter ISBN";
    }else {
      this.appService.sendDeleteItemData(this.deleteISBN).subscribe((data: any) => {
        this.postRequestResponse = data.content;
      });
    }
  }
}
