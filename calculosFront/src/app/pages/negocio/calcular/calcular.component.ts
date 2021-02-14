import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { OPERADORES } from 'src/app/providers/enum/OperadoresEnum';
import { CalcularService } from 'src/app/providers/service/calcular/calcular.service';
import { ToastService } from 'src/app/providers/toast/toast.service';

@Component({
  selector: 'app-calcular',
  templateUrl: './calcular.component.html',
  styleUrls: ['./calcular.component.sass']
})
export class CalcularComponent implements OnInit {

  /** Variable para la validación del formulario */
  public formNumero: FormGroup;
  public formOperador: FormGroup;
  public operadores = [];
  public acumulado = "Acumulado: ";
  public resultado = "Resultado: ";
  public numeroAcumulado;
  public numeroResultado;

  constructor(private calcularService: CalcularService,
    private formBuilder: FormBuilder,
    private toast: ToastService) { }

  ngOnInit(): void {
    this.formNumero = this.formBuilder.group({
      numero: new FormControl('', [Validators.required]),
    })
    this.formOperador = this.formBuilder.group({
      operador: new FormControl('', [Validators.required]),
    })
    this.armarOperadores();
  }

  agregarNumero() {
    if (this.formNumero.valid && !isNaN(parseInt(this.formNumero.get('numero').value))) {
      let numero = parseInt(this.formNumero.get('numero').value)

      this.calcularService.agregarOperando(numero).subscribe(
        res => {
          if (res.status == 200) {
            this.numeroAcumulado = JSON.stringify(res.body);
            this.acumulado = "Acumulado: " + this.numeroAcumulado;
            this.acumulado = this.acumulado.replace("[", "").replace("]", "")
            this.toast.mensage(this.toast.exito, "Se agrego el numero correctamente");
          } else {
            this.toast.mensage(this.toast.error, "Ocurrio un error en el servicio");
          }
        }
      )
    }else{
      this.toast.mensage(this.toast.alerta, this.formNumero.valid?"El dato ingesado no es un numero valido":"Ingrese un numero para enviar");
    }
  }

  calcular() {
    if (this.formOperador.valid) {
      let operador = this.formOperador.get('operador').value
      this.calcularService.calcular(operador).subscribe(
        res => {
          if (res.status == 200) {
            this.numeroResultado = res.body
            this.resultado = "Resultado: " + this.numeroResultado;
            this.toast.mensage(this.toast.exito, "Se realizo la operacion exitosamente");

          } else if(res.status == 101){
            this.toast.mensage(this.toast.alerta, res.body);
          }
        }
      )
    }else{
      this.toast.mensage(this.toast.alerta, "Ingrese una operación para enviar");
    }
  }

  limpiar(){
    this.calcularService.limpiar().subscribe(
      res=>{
        if(res.status == 200){
          this.toast.mensage(this.toast.exito, "Se limpiaron los operandos");
          this.numeroAcumulado = undefined;
        }
      }
    )
  }


  armarOperadores() {
    this.operadores = Object.values(OPERADORES);
  }

}
