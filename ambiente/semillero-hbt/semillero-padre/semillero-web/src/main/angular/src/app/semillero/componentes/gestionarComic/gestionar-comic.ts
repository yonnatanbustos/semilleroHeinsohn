
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarComicService } from '../../services/gestionar.comic.service';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm: FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics: Array<ComicDTO>;

    public idComic: number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb: FormBuilder,
        private router: Router,
        private gestionarComicService: GestionarComicService) {
        this.gestionarComicForm = this.fb.group({
            nombre: [null, Validators.required],
            editorial: [null],
            tematica: [null],
            coleccion: [null],
            numeroPaginas: [null],
            precio: [null],
            autores: [null],
            color: [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit 1");
        this.comic = null;
        this.listaComics = new Array<ComicDTO>();
        this.consultarComics();
        this.ejemplo();
    }

    /**
     * @description Metodo encargado de consultar los comics existentes
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    public consultarComics(): void {
        this.gestionarComicService.consultarComics().subscribe(listaComics => {
            this.listaComics = listaComics;
        }, error => {
            console.log(error);
        });
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarComic(): void {
        this.submitted = true;
        if (this.gestionarComicForm.invalid) {
            return;
        }
        let json = JSON.stringify(this.comic);
        alert("El comic:\n" + json);
        if (this.comic === null) {
            this.comic = new ComicDTO();
            this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
            this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
            this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
            this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.comic.precio = this.gestionarComicForm.controls.precio.value;
            this.comic.autores = this.gestionarComicForm.controls.autores.value;
            this.comic.color = this.gestionarComicForm.controls.color.value;
            this.comic.cantidad = 12;
            this.comic.estado = "ACTIVO";

            this.gestionarComicService.crearComic(this.comic).subscribe(resultadoDTO => {
                if (resultadoDTO.exitoso) {
                    alert("El comic " + this.comic.nombre + " se creo correctamente")
                    this.consultarComics();
                    this.limpiarFormulario();
                }
            }, error => {
                console.log(error);
                alert("Error:\n" + error);
            });
        } else {

            alert("Id comic editar " + this.comic.id);
            this.obtenerInformacion();
            this.gestionarComicService.modificarComic(this.comic).subscribe(resultado => {
                this.consultarComics();
                this.limpiarFormulario();
                alert("EL resultado de la modificacion es:\n"+resultado);
            });
        }


    }

    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public consultarComic(posicion: number): void {
        this.comic = this.listaComics[posicion];
        this.router.navigate(['consultar-comic', this.comic]);
        this.comic = null;
    }

    /**
     * 
     * @param posicion 
     */
    public modificarComic(posicion: number): void {
        this.ejemplo();
        this.cargarInformacion(posicion);
    }


    public eliminarComic(comic: ComicDTO) {
        //this.comic = this.listaComics[posicion];
        alert("id comic eliminar " + comic.id);
        this.gestionarComicService.eliminarComic(comic.id).subscribe(resultado => {
            this.consultarComics();
            this.limpiarFormulario();
            alert("El resultado de la eliminacion es:\n"+resultado);
        });
    }


    private limpiarFormulario(): void {
        this.submitted = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
        this.comic = null;
    }


public ejemplo():void{
    for (let i = 0; i < this.listaComics.length; i++) {
        console.log("Tematic #"+i+" "+this.listaComics[i].tematica);

    }

}


    public cargarInformacion(posicion: number): void {
        this.comic = this.listaComics[posicion];
        alert(this.comic.tematica);
        this.gestionarComicForm.controls.nombre.setValue(this.comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(this.comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(this.comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(this.comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(this.comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(this.comic.precio);
        this.gestionarComicForm.controls.autores.setValue(this.comic.autores);
        this.gestionarComicForm.controls.color.setValue(this.comic.color);
    }


    public obtenerInformacion(): void {
        this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
        this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;
    }


    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() {
        return this.gestionarComicForm.controls;
    }
}