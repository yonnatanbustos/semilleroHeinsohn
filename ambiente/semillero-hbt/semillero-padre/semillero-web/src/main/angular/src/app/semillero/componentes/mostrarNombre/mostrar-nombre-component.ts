import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

/**
 * @description 
 * 
 */
@Component({
    selector:'mostrar-nombre',
    templateUrl: './mostrar-nombre-component.html'
})

export class MostrarNombreComponent implements OnInit{


public nombre:String;

public ciudad:String;

public urlRepositorio: String;

constructor(private router: Router){

}

ngOnInit(): void {
    this.nombre = "Yonnatan Eduardo Bustos Rodriguez";
    this.ciudad = "Armenia";
    this.urlRepositorio = "https://github.com/yonnatanbustos/semilleroHeinsohn.git";
}

}