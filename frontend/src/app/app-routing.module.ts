import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { CompaniesComponent } from './components/companies/companies.component';
import { CreateCompanyComponent } from './components/companies/create-company/create-company.component';
import { EditCompanyComponent } from './components/companies/edit-company/edit-company.component';
import { IposComponent } from './components/ipos/ipos.component';
import { CreateIpoComponent } from './components/ipos/create-ipo/create-ipo.component';
import { StockExchangesComponent } from './components/stock-exchanges/stock-exchanges.component';
import { CreateStockExchangeComponent } from './components/stock-exchanges/create-stock-exchange/create-stock-exchange.component';
import { EditStockExchangesComponent } from './components/stock-exchanges/edit-stock-exchanges/edit-stock-exchanges.component';
import { ImportExcelComponent } from './components/import-excel/import-excel.component';
import { ComparisonChartsComponent } from './components/comparison-charts/comparison-charts.component';
import { SectorsComponent } from './components/sectors/sectors.component';
import { CreateSectorComponent } from './components/sectors/create-sector/create-sector.component';
import { EditSectorComponent } from './components/sectors/edit-sector/edit-sector.component';
import { ChartsModule } from 'ng2-charts';
import { StockPriceService } from './services/stock-price.service';
import { ComparisonSectorComponent } from './components/comparison-sector/comparison-sector.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'companies', component: CompaniesComponent },
  { path: 'create-company', component: CreateCompanyComponent },
  { path: 'edit-company/:id', component: EditCompanyComponent },
  { path: 'edit-sector/:id', component: EditSectorComponent },
  { path: 'edit-stock-exchange/:id', component: EditStockExchangesComponent },
  { path: 'ipos', component: IposComponent },
  { path: 'create-ipo', component: CreateIpoComponent },
  { path: 'stock-exchanges', component: StockExchangesComponent },
  { path: 'create-stock-exchange', component: CreateStockExchangeComponent },
  { path: 'sectors', component: SectorsComponent },
  { path: 'create-sector', component: CreateSectorComponent },
  { path: 'import-excel', component: ImportExcelComponent },
  { path: 'comparison-charts', component: ComparisonChartsComponent },
  { path: 'comparison-sector', component: ComparisonSectorComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes), ChartsModule],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
