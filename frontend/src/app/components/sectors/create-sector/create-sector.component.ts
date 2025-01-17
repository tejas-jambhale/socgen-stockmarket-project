import { Component, OnInit } from '@angular/core';

import { Sector } from '../../../models/Sector';
import { SectorService } from '../../../services/sector.service';

@Component({
  selector: 'app-create-sector',
  templateUrl: './create-sector.component.html',
  styleUrls: ['./create-sector.component.css']
})
export class CreateSectorComponent implements OnInit {

  sector: Sector = {
    name: '',
    brief: ''
  }

  constructor(private sectorService: SectorService) { }

  ngOnInit(): void {
  }

  onSubmit({ value, valid }: { value: Sector, valid: boolean }) {

    this.sectorService.addSector(value);

  }
}
