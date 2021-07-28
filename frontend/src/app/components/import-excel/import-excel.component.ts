import { Component, OnInit, ElementRef } from '@angular/core';
import * as XLSX from 'xlsx';
import { Chart } from 'chart.js';

import { StockPrice } from '../../models/StockPrice';
import { StockPriceService } from '../../services/stock-price.service';

@Component({
  selector: 'app-import-excel',
  templateUrl: './import-excel.component.html',
  styleUrls: ['./import-excel.component.css']
})
export class ImportExcelComponent implements OnInit {

  chart: any = [];
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

  constructor(private stockPriceService: StockPriceService, private elementRef: ElementRef) { }

  ngOnInit(): void {
  }

  onUpload(event) {
    this.file = event.target.files[0];
    let fileReaderFn = new FileReader();
    fileReaderFn.readAsArrayBuffer(this.file);
    fileReaderFn.onload = (e) => {
      this.arrayBuffer = fileReaderFn.result;
      var dataArr = new Uint8Array(this.arrayBuffer);
      var arr = new Array();
      let htmlRef = (<HTMLCanvasElement>document.getElementById("canvasId")).getContext('2d');
      for (var i = 0; i != dataArr.length; ++i) {
        arr[i] = String.fromCharCode(dataArr[i]);
      }
      this.chart = new Chart(htmlRef, {
        type: 'line',
        data: {
          labels: [],
          datasets: [
            {
              data: [],
              borderColor: "green",
              fill: false
            }
          ]
        },
        options: {
          legend: {
            display: true
          },
          scales: {
            xAxes: [{
              display: true
            }],
            yAxes: [{
              display: true
            }],
          }
        }
      });

      var bstr = arr.join("");
      var workbook = XLSX.read(bstr, { type: "binary" });
      var first_sheet_name = workbook.SheetNames[0];
      var worksheet = workbook.Sheets[first_sheet_name];
      var records = XLSX.utils.sheet_to_json(worksheet, { raw: true });
      this.numberOfRecords = records.length;
      records.filter(record => {
        this.stockPrice = {
          companyCode: record["Company Code"],
          stockExchangeName: record["Stock Exchange"],
          price: record["Price"],
          currentPriceDate: record["Date"].trim(),
          time: record["Time"].trim()
        }
        this.stockPrices.push(this.stockPrice);
      });
      console.log(this.stockPrices);
    }

  }


}
