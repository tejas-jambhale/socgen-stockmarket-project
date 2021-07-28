import { Component, OnInit } from '@angular/core';
import * as XLSX from 'xlsx';

import { StockPrice } from '../../models/StockPrice';
import { StockPriceService } from '../../services/stock-price.service';

@Component({
  selector: 'app-import-excel',
  templateUrl: './import-excel.component.html',
  styleUrls: ['./import-excel.component.css']
})
export class ImportExcelComponent implements OnInit {

  file: File;
  arrayBuffer: any;
  fileList: any;
  numberOfRecords: number;
  stockPrices: StockPrice[] = [];
  stockPrice: StockPrice;
  isUploaded: boolean = false;
  companyCode: string;
  stockExchangeName: string;
  fromDate: string;
  toDate: string;

  constructor(private stockPriceService: StockPriceService) { }

  ngOnInit(): void {
  }

  onUpload(event) {
    this.file = event.target.files[0];
    // use file reader to open excel
    let fileReaderFn = new FileReader();
    fileReaderFn.readAsArrayBuffer(this.file);
    fileReaderFn.onload = (e) => {
      this.arrayBuffer = fileReaderFn.result;
      var data = new Uint8Array(this.arrayBuffer);
      var arr = new Array();
      for (var i = 0; i != data.length; ++i) {
        arr[i] = String.fromCharCode(data[i]);
      }

      //parse the excel
      var str = arr.join("");
      var workbook = XLSX.read(str, { type: "binary" });
      var first_sheet_name = workbook.SheetNames[0];
      var worksheet = workbook.Sheets[first_sheet_name];
      var records = XLSX.utils.sheet_to_json(worksheet, { raw: true });
      this.numberOfRecords = records.length;

      //filter the records in the excel
      records.filter(record => {
        this.stockPrice = {
          companyCode: record["Company Code"],
          stockExchangeName: record["Stock Exchange"],
          price: record["Price Per Share(in Rs)"],
          currentPriceDate: record["Date"].trim(),
          time: record["Time"].trim()
        }
        this.stockPrices.push(this.stockPrice);
      });
      console.log(this.stockPrices);
      // save stock price data
      this.stockPriceService.addStockPriceList(this.stockPrices);
      this.companyCode = this.stockPrices[0].companyCode;
      this.stockExchangeName = this.stockPrices[0].stockExchangeName;
      this.fromDate = this.stockPrices[0].currentPriceDate;
      this.toDate = this.stockPrices[this.numberOfRecords - 1].currentPriceDate;
      this.isUploaded = true;
    }

  }
}
