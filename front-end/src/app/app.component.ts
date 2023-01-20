import {Component, OnInit, ViewChild} from '@angular/core';
import {
  ChartComponent,
  ApexAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexDataLabels,
  ApexTooltip,
  ApexStroke
} from "ng-apexcharts";
import {TemperatureService} from "./services/temperature.service";

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  stroke: ApexStroke;
  tooltip: ApexTooltip;
  dataLabels: ApexDataLabels;
};

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  lastTemp: any;
  lastDate: any;

  @ViewChild("chart") chart!: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  records: any;
  dates: string[] = [];
  temperatures: number[] = [];

  dataTable:any;

  ngOnInit() {
    this.getAllRecords();
  }

  constructor(private tempService: TemperatureService) {

    this.chartOptions = {
      series: [
        {
          name: "series1",
          data: this.temperatures
        }
      ],
      chart: {
        height: 350,
        type: "area"
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        curve: "smooth"
      },
      xaxis: {
        type: "datetime",
        categories: this.dates
      },
      tooltip: {
        x: {
          format: "dd/MM/yy HH:mm"
        }
      }
    };
  }

  getAllRecords() {
    this.tempService.getAllRecords().subscribe(
      data => {
        this.records = data;
        // @ts-ignore
        for (let obj of data) {
          this.dates.push(obj.date);
          this.temperatures.push(obj.temperature);
          this.lastTemp=this.temperatures[this.temperatures.length-1];
          this.lastDate=this.dates[this.dates.length-1];
          this.dataTable=this.records.slice(Math.max(this.records.length - 10, 0));
        }
      }
    )
  }

}
