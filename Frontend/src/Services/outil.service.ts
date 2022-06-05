import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Outils } from 'src/Models/outil.model';

@Injectable({
  providedIn: 'root'
})
export class OutilService {

  public tab2: Outils[] = [];
  constructor(private httpClient: HttpClient) { }
  saveTools(tool: Outils): Promise<Outils> {
    return this.httpClient.post<Outils>('http://localhost:9000/OUTIL-SERVICE/outil/newTool', tool).toPromise();

  }

  getToolById(id: string): Promise<Outils> {
    return this.httpClient.get<Outils>('http://localhost:9000/OUTIL-SERVICE/outil/' + id).toPromise();
    /*return new Promise(resolve => resolve(
      this.tab.filter(item => item.id===id)[0]??null));*/
  }

  RemoveToolById(id: string): Promise<void> {
    return this.httpClient.delete<void>('http://localhost:9000/OUTIL-SERVICE/Outils/' + id).toPromise();

    /*this.tab=this.tab.filter(item => item.id!=id);
    return new Promise(resolve => resolve());*/

  }

  /*GetALLMembers(): Promise<Member[]> {
    //this.httpClient.get<Member>('linkToRestAPI',member).toPromise();
    return new Promise(resolve => resolve(this.tab));

  }*/
  GetALL(): Promise<Outils[]> {
    return this.httpClient.get<any[]>('http://localhost:9000/OUTIL-SERVICE/outils').toPromise();

  }
  EditTool(id: any, tool: Outils): Promise<Outils> {
    return this.httpClient.put<Outils>('http://localhost:9000/OUTIL-SERVICE/outils/outil' + id, tool).toPromise();


  }

}
