import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient} from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { ResponseService } from 'src/app/model/response.model';
import { OPERADORES } from '../../enum/OperadoresEnum';

@Injectable({
  providedIn: 'root'
})
export class CalcularService {

  private endpoint =environment.apiBaseUrl;
  private servicio = "/calculos"
  constructor(private http: HttpClient) { }

  public agregarOperando(numero:number){
    return this.http.post(this.endpoint+this.servicio+"/agregarOperando",numero).pipe(tap((resp: ResponseService)=> resp));
  }

  public calcular(operador:string){
    return this.http.post(this.endpoint+this.servicio+"/calcular",operador).pipe(tap((resp: ResponseService)=> resp));
  }

  public limpiar(){
    return this.http.get(this.endpoint+this.servicio+"/limpiar").pipe(tap((resp: ResponseService)=> resp));
  }
}
