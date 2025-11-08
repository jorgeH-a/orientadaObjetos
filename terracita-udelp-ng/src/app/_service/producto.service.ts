import { Injectable } from '@angular/core';
import { Producto } from '../_class/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  data:Producto[]=[
     
        {id:1,nombre:"Coca-Cola",precio:20,existencia:50,categoria:"Bebidas",estado:"Activo"},
        {id:2,nombre:"Sabritas",precio:25,existencia:30,categoria:"Comida",estado:"Activo"},
        {id:3,nombre:"Chetos",precio:25,existencia:30,categoria:"Comida",estado:"Activo"},
      ];
    
      constructor(){  }
    
      getAll(): Producto[] {
        return this.data;
      }
    
      get(id:number): Producto | undefined {
    
        return this.data.find(d=>d.id==id);
      }
    
      add(value:Producto){
        this.data.push(value);
      }
    
      edit(value:Producto){
        const index = this.data.findIndex(d => d.id === value.id);
        if (index !== -1) {
          this.data[index] = value;
        }
      }
    
      delete(id:number){
        this.data = this.data.filter(d => d.id !== id);
      }
}
