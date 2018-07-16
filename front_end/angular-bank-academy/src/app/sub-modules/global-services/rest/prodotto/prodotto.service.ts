import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from '../../../../../environments/environment';
import { Cliente } from './../../model/cliente';

@Injectable({
  providedIn: 'root'
})
export class ProdottoService {

  constructor(private http: HttpClient) { }

  getProdotti(): Observable<any> {
    return this.http.get(environment.baseUrl + '/bank-academy/rest/prodotti/getProdottiList').pipe(
      catchError(this.handleError)
    );
  }

  consiglioProdotto(cliente: Cliente): Observable<any> {
    return this.http.post(environment.baseUrl + '/bank-academy/rest/prodotti/getProdottoConsiglio', cliente).pipe(
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
