import { Component, OnInit } from '@angular/core';
import { Sector } from '../../../models/Sector';
@Component({
  selector: 'app-edit-sector',
  templateUrl: './edit-sector.component.html',
  styleUrls: ['./edit-sector.component.css']
})
export class EditSectorComponent implements OnInit {

  brief: any;
  sectorForm: any;
  sector: Sector = {
    name: '',
    brief: ''
  };
  constructor() { }

  ngOnInit(): void {
  }
  onSubmit({ value, valid }: { value: Sector, valid: boolean }) {

  }
}
