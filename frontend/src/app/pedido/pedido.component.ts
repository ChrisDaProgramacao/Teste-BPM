import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Pedido } from './pedido.model';

import { ApiService } from '../api.service';
import { empty } from 'rxjs';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrls: ['./pedido.component.scss']
})
export class PedidoComponent implements OnInit {

  formPedido: FormGroup;
  isPedido: boolean;

  pedidoAtual: Pedido;

  constructor(private fb: FormBuilder, private route: ActivatedRoute, private service: ApiService) {
    this.isPedido = this.route.snapshot.url[0].path === 'pedido';
  }

  ngOnInit() {
    this.createForm();

    if (!this.isPedido) {
      this.loadFieldValues();
    }
  }

  createForm() {
    this.formPedido = this.fb.group({
      nome: [{ value: '', disabled: !this.isPedido }],
      descricao: [{ value: '', disabled: !this.isPedido }],
      preco: [{ value: '', disabled: !this.isPedido }],
    });

    if (!this.isPedido) {
      this.formPedido.addControl('status', this.fb.control(''));
    }
  }

  loadFieldValues() {
    this.service.getPending().subscribe((pedido: Pedido) => {
      this.pedidoAtual = pedido;
      this.formPedido.patchValue({ ...pedido });
    });
  }

  save() {
    const objSave = { ...this.pedidoAtual, ...this.formPedido.getRawValue() };
    this.service.save(objSave).subscribe((pedido: Pedido) => {
      this.loadFieldValues();
      this.clear();
    });
  }

  clear() {
    this.formPedido.reset();
    this.pedidoAtual.descricao="";
  }

}
