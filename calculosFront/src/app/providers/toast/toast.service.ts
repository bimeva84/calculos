import { Injectable } from '@angular/core';
import {IndividualConfig, ToastrService} from 'ngx-toastr';
import { Router } from '@angular/router';

@Injectable()
export class ToastService {

  public exito = 1;
  public info = 2;
  public alerta = 3;
  public error = 4;

  public config: any = {
    progressBar: true,
    progressAnimation: 'increasing',
    closeButton: true,
    positionClass: 'toast-bottom-full-width',
    timeOut: 3000,
    extendedTimeOut: 10000
  };

  constructor(private router: Router, public toastr: ToastrService) {
  }

  public mensage(tipo: number, mensage: string) {
    switch (tipo) {
      case 1: {
        this.toastr.success(mensage, '', this.config);
        break;
      }
      case 2: {
        this.toastr.info(mensage, '', this.config);
        break;
      }
      case 3: {
        this.toastr.warning(mensage, '', this.config);
        break;
      }
      case 4: {
        this.toastr.error(mensage, '', this.config);
        break;
      }
    }
  }

  public mensajeExitoso(){
    this.toastr.success('Se ha realizado la operación con éxito', 'Exito!', this.config);
  }

  public mensajeObligatoriedad(){
    this.toastr.warning('Por favor llene los campos obligatorios', 'Alerta!', this.config);
  }

}
