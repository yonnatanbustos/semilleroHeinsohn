import { Component, OnInit } from "@angular/core";
import { ProveedorDTO } from '../../dto/proveedor.dto';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { GestionarProveedorService } from '../../services/gestionar.proveedor.service';


@Component({
    selector: 'gestionar-proveedor',
    templateUrl: './gestionar-proveedor-component.html'
})
/**
 * @description Componenete gestionar proveedor, el cual contiene la logica CRUD
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 */
export class GestionarProveedorComponent implements OnInit {



    public proveedor: ProveedorDTO;

    public gestionarProveedorForm: FormGroup;

    public listaProveedores: Array<ProveedorDTO>;

    /**
     * Constructor de la clase
     * @param fb 
     * @param router 
     * @param gestionarProveedorService 
     */
    constructor(private fb: FormBuilder,
        private router: Router, private gestionarProveedorService: GestionarProveedorService
    ) {
        this.gestionarProveedorForm = this.fb.group({
            nombreProveedor: [null, Validators.required],
            numIdentificacion: [null],
            direccion: [null],
            montoCredito: [null],
            estado: [null],
        });
    }


    /**
     * 
     */
    ngOnInit(): void {

        this.proveedor = null;
        this.listaProveedores = new Array<ProveedorDTO>();
        this.consultarProveedores();

    }

    /**
     * @description Metodo encargado de consultar los proveedores existentes
     * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
     */
    public consultarProveedores(): void {
        this.gestionarProveedorService.consultarProveedores().subscribe(listaProveedores => {
            this.listaProveedores = listaProveedores;
        });

    }

    /**
     * @description
     * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
     */
    public crearActualizarProveedor(): void {
        if (this.gestionarProveedorForm.invalid) {
            return;
        }

        if (this.proveedor === null) {
            if (this.listaProveedores.length===30) {
                alert("No puede crear mas de 30 proveedores");
                return;
            }
            this.proveedor = new ProveedorDTO();
            this.obtenerInformacion();
            this.proveedor.fechaCreacion = new Date();


            try {
                this.gestionarProveedorService.crearProveedor(this.proveedor).subscribe(resultado => {
                    if (resultado.exitoso) {
                        this.consultarProveedores();
                        this.limpiarFormulario();
                        alert("Se creo el proveedor");
                    }
                });
            } catch (error) {
                alert("Error:\n"+error);
            }
       
        } else {
            this.obtenerInformacion();
            this.gestionarProveedorService.modificarProveedor(this.proveedor.id, this.proveedor.nombre,
                this.proveedor.montoCredito).subscribe(resultado => {
                    this.limpiarFormulario();
                    this.consultarProveedores();
                });
        }
    }

/**
 * @description
 * @author
 * @param posicion 
 */
    public consultarProveedor(posicion: number): void {

        this.proveedor = this.listaProveedores[posicion];
        this.router.navigate(['consultar-proveedor', this.proveedor]);
        this.proveedor = null;
    }

    /**
     * @description
     * @author 
     * @param posicion 
     */
    public modificarProveedor(posicion: number): void {
        this.cargarInformacion(posicion);
    }

    public cambiarEstadoProveedor(posicion: number): void {

    }


    /**
     * @description
     * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
     */
    private limpiarFormulario(): void {
        this.gestionarProveedorForm.controls.nombreProveedor.setValue(null);
        this.gestionarProveedorForm.controls.numIdentificacion.setValue(null);
        this.gestionarProveedorForm.controls.direccion.setValue(null);
        this.gestionarProveedorForm.controls.montoCredito.setValue(null);
        this.gestionarProveedorForm.controls.estado.setValue(null);
        this.proveedor = null;
    }
    /**
     * @description
     * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
     */
    private obtenerInformacion(): void {
        this.proveedor.nombre = this.gestionarProveedorForm.controls.nombreProveedor.value;
        this.proveedor.numIdentificacion = this.gestionarProveedorForm.controls.numIdentificacion.value;
        this.proveedor.direccion = this.gestionarProveedorForm.controls.direccion.value;
        this.proveedor.montoCredito = this.gestionarProveedorForm.controls.montoCredito.value;
        this.proveedor.estado = this.gestionarProveedorForm.controls.estado.value;
    }

    /**
     * @description
     * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
     * @param posicion 
     */
    private cargarInformacion(posicion: number): void {
        this.proveedor = this.listaProveedores[posicion];

        this.gestionarProveedorForm.controls.nombreProveedor.setValue(this.proveedor.nombre);
        this.gestionarProveedorForm.controls.numIdentificacion.setValue(this.proveedor.numIdentificacion);
        this.gestionarProveedorForm.controls.direccion.setValue(this.proveedor.direccion);
        this.gestionarProveedorForm.controls.montoCredito.setValue(this.proveedor.montoCredito);
        this.gestionarProveedorForm.controls.estado.setValue(this.proveedor.estado);

    }



}