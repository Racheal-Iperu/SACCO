import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = environment.apiUrl + '/api/v1/student' ; // Construct the API URL

  constructor(private http: HttpClient) { }

  createDocument(studentData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/save`, studentData);
  }

  editDocument(studentData: any,id:string): Observable<any> {
    return this.http.put(`${this.apiUrl}/edit/${id}`, studentData);
  }
}
