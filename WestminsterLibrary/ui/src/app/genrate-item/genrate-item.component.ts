import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-genrate-item',
  templateUrl: './genrate-item.component.html',
  styleUrls: ['./genrate-item.component.css']
})
export class GenrateItemComponent implements OnInit {


  //Declaring variables
  private getReportDetails = '/api/generateReport';
  private getDVDDetails = '/api/displayDVD';

  readerDetails

  constructor(private appService: AppService ) { }

  ngOnInit() {
    //geting reports details from back end
    this.appService.displayReport(this.getReportDetails).subscribe((data: any) => {
      this.readerDetails = data;
    });
  }
}
