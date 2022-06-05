import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-confirm-dialog',
  templateUrl: './confirm-dialog.component.html',
  styleUrls: ['./confirm-dialog.component.css']
})
export class ConfirmDialogComponent implements OnInit {
  public titre = "Are you sure";
  public Message = " if you want delete this item";
  public cancel = " cancel";
  public confirm = "delete";

  constructor(public dialogRef: MatDialogRef<ConfirmDialogComponent>) { }



  ngOnInit(): void {
  }

}
