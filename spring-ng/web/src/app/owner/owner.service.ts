import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contact } from './owner.model';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class OwnerService {

  constructor(private http: HttpClient) { }

  getContact(): Observable<Contact> {
    return this.http.get<Contact>(`${environment.api}/contact`);
  }
}
