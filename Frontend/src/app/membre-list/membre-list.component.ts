
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Members } from 'src/Models/member.model';
import { MembersService } from 'src/Services/members.service';

import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';


@Component({
  selector: 'app-membre-list',
  templateUrl: './membre-list.component.html',
  styleUrls: ['./membre-list.component.css']
})
export class MembreListComponent implements OnInit {

  //any : quelque soit le type
  dataSource: MatTableDataSource<Members> = new MatTableDataSource(this.ms.tabb);
  //3al 9ad ma3andik columns tzidou fi displayedcolumns ==9adeh 3andik min ngcontainer fil html
  displayedColumns: string[] = ["cin", "prenom", "nom", "email", "dateNaissance", "cv", "Actions"];

  //fil constructeur na3mel instance min il service : ma3neha injectit il service 
  constructor(private ms: MembersService, private router: Router, private dialog: MatDialog) {
    this.dataSource = new MatTableDataSource(this.ms.tabb);
  }
  delete(id: string) {

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {})
    // nlanci thread de type observable :no93ed netssana mba3d massakarha il user w nestana il retour de la type boolean 
    dialogRef.afterClosed().subscribe(
      isDeleted => {
        if (isDeleted) {
          //exécute de code de la suppression 
          console.log(id);
          this.ms.RemoveMemberById(id).then(() => this.GetMembers());

        }
      }

    )
  }
  GetMembers(): void {
    //.then((awelparamétre houwa chnou jek min il resolve)=>{chhnou na3mel a3lih})
    //this.ms.GetAllMembers().then((data) => {
    //.data  accéder au données de table de type MatTableDataSource
    //this.dataSource.data = data
    // })

    //this.ms.GetALL().then((data)=>this.dataSource.data=data);
    //console.log(this.dataSource.data);
    this.ms.GetALL()
      .then((data) => {
        this.dataSource.data = data;
      });
    //console.log(this.dataSource.data);
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();


  }


  ngOnInit(): void {
    this.GetMembers();
  }

}
