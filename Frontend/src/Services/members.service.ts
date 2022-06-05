import { Injectable } from '@angular/core';
import { GLOBAL } from 'src/app/app-config';
import { HttpClient } from '@angular/common/http';
import { Members } from 'src/Models/member.model';


@Injectable({
  providedIn: 'root'
})
export class MembersService {


  public tabb: Members[] = [];


  public edittab: any = [];
  public tab = GLOBAL._db.members;
  constructor(private httpClient: HttpClient) { }
  saveEtudiant(member: Members): Promise<Members> {
    return this.httpClient.post<Members>('http://localhost:9000/MEMBRE-SERVICE/membres/etudiant', member).toPromise();
    /*const memberToSave =  {...member,}
    memberToSave.id = member.id??Math.ceil(Math.random()*10000).toString();
    memberToSave.createDate = member.createDate??new Date().toString();
    this.tab=[memberToSave,...this.tab.filter(item => item.id!==memberToSave.id)];
    return new Promise(resolve => resolve(memberToSave));*/
  }
  saveEnseignant(member: Members): Promise<Members> {
    return this.httpClient.post<Members>('http://localhost:9000/MEMBRE-SERVICE/membres/enseignant', member).toPromise();
    /*const memberToSave =  {...member,}
    memberToSave.id = member.id??Math.ceil(Math.random()*10000).toString();
    memberToSave.createDate = member.createDate??new Date().toString();
    this.tab=[memberToSave,...this.tab.filter(item => item.id!==memberToSave.id)];
    return new Promise(resolve => resolve(memberToSave));*/
  }

  getMemberById(id: string): Promise<Members> {
    return this.httpClient.get<Members>('http://localhost:9000/MEMBRE-SERVICE/membre/' + id).toPromise();
    /*return new Promise(resolve => resolve(
      this.tab.filter(item => item.id===id)[0]??null));*/
  }

  RemoveMemberById(id: string): Promise<void> {
    return this.httpClient.delete<void>('http://localhost:9000/MEMBRE-SERVICE/membres/' + id).toPromise();

    /*this.tab=this.tab.filter(item => item.id!=id);
    return new Promise(resolve => resolve());*/

  }

  /*GetALLMembers(): Promise<Member[]> {
    //this.httpClient.get<Member>('linkToRestAPI',member).toPromise();
    return new Promise(resolve => resolve(this.tab));

  }*/
  GetALL(): Promise<Members[]> {
    return this.httpClient.get<any[]>('http://localhost:9000/MEMBRE-SERVICE/membres').toPromise();

  }
  EditMember(id: any, member: Members): Promise<Members> {
    return this.httpClient.put<Members>('http://localhost:9000/MEMBRE-SERVICE/membres/etudiant/' + id,
      member).toPromise();


  }

}
