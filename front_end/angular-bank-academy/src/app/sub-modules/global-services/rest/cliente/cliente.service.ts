import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from '../../../../../environments/environment';
import { Cliente } from './../../model/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  constructor(private http: HttpClient) { }

  getClienti(cliente: Cliente): Observable<any> {
    return this.http.post(environment.baseUrl + '/bank-academy/rest/clienti/getClientiList', cliente).pipe(
      catchError(this.handleError)
    );
  }

  deleteCliente(id: Number): Observable<any> {
    return this.http.delete(environment.baseUrl + '/bank-academy/rest/clienti/deleteCliente/'+ id).pipe(
      catchError(this.handleError)
    );
  }

  saveCliente(cliente: Cliente): Observable<any> {
    return this.http.post(environment.baseUrl + '/bank-academy/rest/clienti/saveCliente', cliente).pipe(
      catchError(this.handleError)
    );
  }


  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  }
}
