import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import { Comic } from './comic';

/**
 * @description Componente para mostrar nombre, ciudad y repositorio en la pagina de bienvenida 
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 */
@Component({
    selector:'mostrar-nombre',
    templateUrl: './mostrar-nombre-component.html'
})

export class MostrarNombreComponent implements OnInit{
/**
 * Variable que almacena los comics
 */
public listaComics:Array<Comic>;

/**
 * Variable que permite mostrar la lista de los comics en formato JSON
 */
public comicsJSON : any;
/**
 * Variable que almacena el nombre del comic que se elimino.
 */
public nombreComicEliminar:string;

public estado : boolean;

/**
 * Constructor de la clase.
 * @param router permite direccionar a otros componentes.
 */
constructor(private router: Router){

}
/**
 * Evento angular que se ejecuta al iniciar el componente 
 */
ngOnInit(): void {
    this.listaComics= Array<Comic>();
    this.crearComic();
    this.comicsJSON = JSON.stringify(this.listaComics);
    this.nombreComicEliminar = "";
    this.estado = false;
}

/**
 * Metodo que permite crear los cinco comic solicitados para la actividad.
 */
public crearComic():void {
    //Se crea el primer comic
    let comic = new Comic();
    comic.id = 1;
    comic.nombre = "batman";
    comic.editorial = "marvel";
    comic.tematica ="accion";
    comic.numeroPaginas = 50;
    comic.precio = 60,500.99;
    comic.autores = "Pedrito Barrera";
    comic.aColor = true;
    comic.fechaVenta = new Date("10-10-2019");
    comic.estado = "activo";
    this.listaComics.push(comic);

    //se crea el segundo comic
    comic = new Comic();
    comic.id = 2;
    comic.nombre = "superman";
    comic.editorial = "marvel";
    comic.tematica ="accion";
    comic.numeroPaginas = 30;
    comic.precio = 80,700.99;
    comic.autores = "Patrick Gleason, Andrew Robinson.";
    comic.aColor = true;
    comic.fechaVenta = new Date("10-11-2016");
    comic.estado = "activo";
    this.listaComics.push(comic);

    //se crea el tercer comic
    comic = new Comic();
    comic.id = 3;
    comic.nombre = "x-men";
    comic.editorial = "marvel";
    comic.tematica ="accion";
    comic.numeroPaginas = 20;
    comic.precio = 43,200.99;
    comic.autores = "Jonathan Hickman";
    comic.aColor = true;
    comic.fechaVenta = new Date("09-10-2019");
    comic.estado = "activo";
    this.listaComics.push(comic);

    //se crea el cuarto comic.
    comic = new Comic();
    comic.id = 4;
    comic.nombre = "liga de la justicia";
    comic.editorial = "dc comics";
    comic.tematica ="ficcion";
    comic.numeroPaginas = 70;
    comic.precio = 80,999.99;
    comic.autores = "Carlos Lopez";
    comic.aColor = true;
    comic.fechaVenta = new Date("03-12-2009");
    comic.estado = "activo";
    this.listaComics.push(comic);

    //se crea el quito comic
    comic = new Comic();
    comic.id = 5;
    comic.nombre = "la mujer maravilla";
    comic.editorial = "dc comics";
    comic.tematica ="ficcion";
    comic.numeroPaginas = 40;
    comic.precio = 35,100.99;
    comic.autores = "Tommy Abraham";
    comic.fechaVenta = new Date("01-12-1992");
    comic.estado = "inactivo";
    this.listaComics.push(comic);
}

/**
 * Metodo que se envoca en el evento del boton para eliminar el comic
 * en la posicion 3.
 * @param posicion - posicion que se desea eliminar.
 */
public eventoEliminarComic(posicion : number): void{

    if (this.listaComics.length>posicion) {
        this.nombreComicEliminar = this.listaComics[posicion].nombre;
        this.listaComics.splice(posicion, 1);
        this.estado = true;
    }else{
        this.estado = false;
        alert("Ya se elimino el comic de la posición tres (3).")
    }
}

}