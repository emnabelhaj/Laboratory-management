import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Events } from 'src/Models/evenement.model';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  public tab3: Events[] = [];
  constructor(private httpClient: HttpClient) { }
  saveEvents(event: Events): Promise<Events> {
    return this.httpClient.post<Events>('http://localhost:9000/EVENEMENT-SERVICE/events/evenement', event).toPromise();

  }

  getEventById(id: string): Promise<Events> {
    return this.httpClient.get<Events>('http://localhost:9000/EVENEMENT-SERVICE/event/' + id).toPromise();
    /*return new Promise(resolve => resolve(
      this.tab.filter(item => item.id===id)[0]??null));*/
  }

  RemoveEventById(id: string): Promise<void> {
    return this.httpClient.delete<void>('http://localhost:9000/EVENEMENT-SERVICE/events/' + id).toPromise();

    /*this.tab=this.tab.filter(item => item.id!=id);
    return new Promise(resolve => resolve());*/

  }

  /*GetALLMembers(): Promise<Member[]> {
    //this.httpClient.get<Member>('linkToRestAPI',member).toPromise();
    return new Promise(resolve => resolve(this.tab));

  }*/
  GetALL(): Promise<Events[]> {
    return this.httpClient.get<any[]>('http://localhost:9000/EVENEMENT-SERVICE/events').toPromise();

  }
  EditTool(id: any, event: Events): Promise<Events> {
    return this.httpClient.put<Events>('http://localhost:9000/EVENEMENT-SERVICE/events/evenement/' + id, event).toPromise();


  }
}
