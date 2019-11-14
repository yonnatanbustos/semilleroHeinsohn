import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'consultar-comic',
    templateUrl: './consultar-comic-component.html'
})

/**
 * @description Componente de consultar comic
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 * 
 */
export class ConsultarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public consultarComicForm: FormGroup;

    /**
    * Atributo que contendra la informacion del comic
    */
    public data: any;




    /**
     * constructor del componente
     * @param fb 
     * @param router 
     */
    constructor(private fb: FormBuilder, private router: Router, private activateRoute: ActivatedRoute) {
        this.consultarComicForm = this.fb.group({
            nombre: [null],
            editorial: [null],
            tematica: [null],
            coleccion: [null],
            numeroPaginas: [null],
            precio: [null],
            autores: [null],
            color: [null]
        })
    }


    /**
     * @description Evento angular que se ejecuta al invocar el componente
     */
    ngOnInit(): void {
        this.data = this.activateRoute.snapshot.params;
        this.cargarInformacion();

    }



    /**
     * @description Metodo que permite cargar la informacion a los campos.
     * 
     * 
     */
    public cargarInformacion(): void {
        this.consultarComicForm.controls.nombre.setValue(this.data.nombre);
        this.consultarComicForm.controls.editorial.setValue(this.data.editorial);
        this.consultarComicForm.controls.tematica.setValue(this.data.tematica);
        this.consultarComicForm.controls.coleccion.setValue(this.data.coleccion);
        this.consultarComicForm.controls.numeroPaginas.setValue(this.data.numeroPaginas);
        this.consultarComicForm.controls.precio.setValue(this.data.precio);
        this.consultarComicForm.controls.autores.setValue(this.data.autores);
        this.consultarComicForm.controls.color.setValue(this.data.color);

        this.consultarComicForm.controls.nombre.disable();
        this.consultarComicForm.controls.editorial.disable();
        this.consultarComicForm.controls.tematica.disable();
        this.consultarComicForm.controls.coleccion.disable();
        this.consultarComicForm.controls.numeroPaginas.disable();
        this.consultarComicForm.controls.precio.disable();
        this.consultarComicForm.controls.autores.disable();
        this.consultarComicForm.controls.color.disable();




    }
    /**
     * @description Metodo que nos permite navegar a la pantalla anterior
     */
    public volver(): void {
        this.router.navigate(['gestionar-comic']);
    }


}