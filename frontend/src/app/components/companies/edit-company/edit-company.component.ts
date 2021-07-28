import { Component, OnInit } from '@angular/core';

import { Company } from '../../../models/Company';
import { CompanyService } from 'src/app/services/company.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-company',
  templateUrl: './edit-company.component.html',
  styleUrls: ['./edit-company.component.css']
})
export class EditCompanyComponent implements OnInit {

  company: Company = {
    id: '',
    name: '',
    code: '',
    turnover: '',
    ceo: '',
    boardOfDirectors: '',
    sector: '',
    about: ''
  };
  companyId: String;

  constructor(private companyService: CompanyService, private route: ActivatedRoute) {
    this.route.queryParams.subscribe(params => {
      console.log(params["id"]);
    });
  }

  ngOnInit(): void {

  }

  onSubmit({ value, valid }: { value: Company, valid: boolean }) {

    value["id"] = String(this.companyId);
    this.companyService.updateCompany(value);

  }
}
