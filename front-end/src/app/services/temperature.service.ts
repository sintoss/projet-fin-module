import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TemperatureService {
  private readonly baseUrl = environment.baseUrl;

  constructor(private httpClient: HttpClient) {
  }

  getAllRecords()
  {
    return this.httpClient.get(this.baseUrl+"weather");
  }
  getLastTemperature()
  {
    return this.httpClient.get(this.baseUrl);
  }

}
