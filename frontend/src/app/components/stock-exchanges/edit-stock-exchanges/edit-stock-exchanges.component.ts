import { Component, OnInit } from '@angular/core';
import { StockExchange } from 'src/app/models/StockExchange';

@Component({
  selector: 'app-edit-stock-exchanges',
  templateUrl: './edit-stock-exchanges.component.html',
  styleUrls: ['./edit-stock-exchanges.component.css']
})
export class EditStockExchangesComponent implements OnInit {

  stockExchange: StockExchange = {
    name: '',
    brief: '',
    address: '',
    remarks: ''
  }
  constructor() { }

  ngOnInit(): void {
  }
  onSubmit({ value, valid }: { value: StockExchange, valid: boolean }) {

  }
}
