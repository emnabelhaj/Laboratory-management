import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Publications } from 'src/Models/article.model';

@Injectable({
  providedIn: 'root'
})
export class PublicationsService {

  public tab1: Publications[] = [];
  constructor(private httpClient: HttpClient) { }
  savePub(pub: Publications): Promise<Publications> {
    return this.httpClient.post<Publications>('http://localhost:9000/PUBLICATION-SERVICE/publication/newpub', pub).toPromise();

  }

  getPubById(id: string): Promise<Publications> {
    return this.httpClient.get<Publications>('http://localhost:9000/PUBLICATION-SERVICE/publication/' + id).toPromise();
    /*return new Promise(resolve => resolve(
      this.tab.filter(item => item.id===id)[0]??null));*/
  }

  RemovePubById(id: string): Promise<void> {
    return this.httpClient.delete<void>('http://localhost:9000/PUBLICATION-SERVICE/publications/' + id).toPromise();

    /*this.tab=this.tab.filter(item => item.id!=id);
    return new Promise(resolve => resolve());*/

  }

  /*GetALLMembers(): Promise<Member[]> {
    //this.httpClient.get<Member>('linkToRestAPI',member).toPromise();
    return new Promise(resolve => resolve(this.tab));

  }*/
  GetALL(): Promise<Publications[]> {
    return this.httpClient.get<any[]>('http://localhost:9000/PUBLICATION-SERVICE/Publications').toPromise();

  }
  EditPub(id: any, pub: Publications): Promise<Publications> {
    return this.httpClient.put<Publications>('http://localhost:9000/PUBLICATION-SERVICE/publications/publication/' + id, pub).toPromise();


  }

}
