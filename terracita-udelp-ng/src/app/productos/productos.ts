import { Component, OnInit } from '@angular/core';
import { AppReport } from '../util/app-report';
import { Producto } from '../_class/producto';
import { ProductoService } from '../_service/producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.html',
  styleUrls: ['./productos.css','../app.css'],
  standalone: false
})
export class Productos extends AppReport implements OnInit{

  productos: Producto[]=[];
  showModal =false;
  modalTitle =""
  producto: Producto | null=null; 
  uri= "catalogos-generales/productos";
  
  constructor(private service: ProductoService, router: Router) {
    super(router)
   }

  ngOnInit():void {
    this.productos = this.service.getAll();
  }

  openAddModal(){
    this.modalTitle = "metodos-pago.add-metodo-pago";
    this.producto = null;
    this.showModal=true;
  }

  openEditModal(producto: Producto) {
    this.modalTitle = "metodos-pago.edit-metodo-pago";
    this.producto = producto;
    this.showModal = true;
  }

  closeModalEvent(){
    this.showModal =false;
    this.producto = null;
    this.modalTitle="";
  }

  saveEvent(producto:Producto){
    if(producto.id){
      this.service.edit(producto);
    }else{
      this.service.add(producto);
    }
    
    this.closeModalEvent();
    this.showModalMessage =true;
    this.modalTitleMessage = "messages.sucess";
    this.messageBody = "messages.save-sucess";
  }
}
