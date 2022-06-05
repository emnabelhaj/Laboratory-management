import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Events } from 'src/Models/evenement.model';
import { EventService } from 'src/Services/event.service';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {

  dataSource: MatTableDataSource<Events> = new MatTableDataSource(this.ms.tab3);
  displayedColumns: string[] = ["titre", "lieu", "date", "Actions"];
  constructor(private ms: EventService, private router: Router, private dialog: MatDialog) {
    this.dataSource = new MatTableDataSource(this.ms.tab3);
  }

  delete(id: string) {

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {})
    // nlanci thread de type observable :no93ed netssana mba3d massakarha il user w nestana il retour de la type boolean 
    dialogRef.afterClosed().subscribe(
      isDeleted => {
        if (isDeleted) {
          //exécute de code de la suppression 
          console.log(id);
          this.ms.RemoveEventById(id).then(() => this.GetEvents());

        }
      }

    )
  }
  GetEvents(): void {

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
    this.GetEvents();
  }



}
