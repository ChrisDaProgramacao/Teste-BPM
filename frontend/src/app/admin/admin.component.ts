import { Component, OnInit } from '@angular/core';
import { Pedido } from './pedido.model';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ApiService } from '../api.service';
import { LiteralMapEntry } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  displayedColumns: string[] = ['nome', 'descricao', 'preco', 'status'];
  pedidos: Pedido[] = [];
  formFiltro: FormGroup;

  constructor(private service: ApiService, private fb: FormBuilder) {}

  ngOnInit() {
    this.montaForm();
    this.carregar();
  }

  montaForm() {
    this.formFiltro = this.fb.group({
      filtro: [''],
      status: ['APROVADO'],
    });
  }

  carregar() {
    // this.pedidos = [
    //   {
    //     nome: 'Xris',
    //     descricao: 'Opa',
    //     preco: 10,
    //     status: 'Talkeimesmo'
    //   }
    // ]
    this.formFiltro.addControl(this.newMethod(), this.fb.control(''));
  }

  private newMethod(): string {
    return 'status';
  }

  filtrar(){
    this.pedidos = [];
    this.service
      .getFilteredValues(this.formFiltro.getRawValue())
      .subscribe(res => {
        this.pedidos = res;
      });

  }

}
