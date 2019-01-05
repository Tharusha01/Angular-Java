import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map } from 'rxjs/operators';
import { Observable } from 'rxjs/index';

/**
 * Class representing application service.
 *
 * @class AppService.
 */
@Injectable()
export class AppService {
  private serviceUrl = '/api/summary';
  private dataPostBUrl = '/api/postBook';
  private dataPostDUrl = '/api/postDVD';
  private addReaderUrl = '/api/addReader';
  private borrowBookUrl = '/api/borrowBook ';
  private borrowDVDUrl = '/api/borrowDVD ';
  private dataPostBookUrl = '/api/addNewBook';
  private dataPostDVDUrl = '/api/addNewDVD';
  private displayBookUrl = '/api/displayBook';
  private displayDVDUrl = '/api/displayDVD';
  private deleteItemUrl = '/api/deleteItem';
  private generateReportUrl = '/api/generateReport';
  private returnItemUrl = '/api/returnItem';
  private searchItemUrl = '/api/searchItem';

  constructor(private http: HttpClient) {
  }

  /**
   * Makes a http get request to retrieve the welcome message from the backend service.
   */
  public getWelcomeMessage() {
    return this.http.get(this.serviceUrl).pipe(
      map(response => response)
    );
  }

  /**
   * Makes a http post request to send some data to backend & get response.
   */
  public sendBData(): Observable<any> {
    return this.http.post(this.dataPostBUrl, {});
  }

  public sendDData(): Observable<any> {
    return this.http.post(this.dataPostDUrl, {});
  }

  //Send data to addBook method
  public sendBookData(bookISBN:string, bookTitle:string, bookSector:string, bookAuthor:string, bookPpublisher:string, bookPublishedDate:string, bookNumberOfPage:string): Observable<any> {
    return this.http.post(this.dataPostBookUrl, bookISBN+"@"+bookTitle+"@"+bookSector+"@"+bookAuthor+"@"+bookPpublisher+"@"+bookPublishedDate+"@"+bookNumberOfPage, {});
  }

  //Send data to addDVD item method
  public sendDVDData(dvdISBN:string, dvdTitle:string, dvdSector:string, dvdLanguage:string, dvdSub:string, dvdProduser:string, dvdActor:string): Observable<any> {
    return this.http.post(this.dataPostDVDUrl, dvdISBN+"@"+dvdTitle+"@"+dvdSector+"@"+dvdLanguage+"@"+dvdSub+"@"+dvdProduser+"@"+dvdActor,{});
  }

  //Send data to addBook method
  public sendReaderData(rId:string, rName:string, rMobile:string, rEmail:string): Observable<any> {
    return this.http.post(this.addReaderUrl, rId+"@"+rName+"@"+rMobile+"@"+rEmail, {});
  }

  //Send data to borrowItem method
  public sendBorrowBookData(bISBN:string, bRName:string, bDate:string, bBookTime:string): Observable<any> {
    return this.http.post(this.borrowBookUrl, bISBN+"@"+bRName+"@"+bDate+"@"+bBookTime, {});
  }

  //Send data to borrowItem method
  public sendBorrowDVDData(bISBN:string, bRName:string, bDate:string, bDVDTime:string): Observable<any> {
    return this.http.post(this.borrowDVDUrl, bISBN+"@"+bRName+"@"+bDate+"@"+bDVDTime, {});
  }

  //Send data to deleteItem method
  public sendDeleteItemData(dISBN:string): Observable<any> {
    return this.http.post(this.deleteItemUrl, dISBN+"@", {});
  }

  //Send data to display Book method
  public displayBook(displayBookUrl: any): Observable<any> {
    return this.http.post(this.displayBookUrl, {});
  }

  //Send data to display DVD method
  public displayDVD(displayDVDUrl: any): Observable<any> {
    return this.http.post(this.displayDVDUrl, {});
  }

  //Send data to display DVD method
  public displayReport(generateReportUrl: any): Observable<any> {
    return this.http.post(this.generateReportUrl, {});
  }

  //Send data to return Item Data
  public returnItem(rISBN:string, rDate:string, rTime:string): Observable<any> {
    return this.http.post(this.returnItemUrl, rISBN+"@"+rDate+"@"+rTime, {});
  }

  //Send data to return Item Data
  public sendSearchData(sTitle:string): Observable<any> {
    return this.http.post(this.searchItemUrl, sTitle+"@", {});
  }

}
