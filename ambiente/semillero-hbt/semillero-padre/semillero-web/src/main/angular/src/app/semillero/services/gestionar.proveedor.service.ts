import { ProveedorDTO } from '../dto/proveedor.dto';
import { Injector, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar proveedor
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 */
export class GestionarProveedorService {

    /**
     * Constructor de la clase
     * @param injector 
     * @param httpClient 
     */
    constructor(injector: Injector, private httpClient: HttpClient) {

    }

    /**
     * @description Metodo encargado de invocar el servicio REST de crear proveedor
     * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
     * @param provedorDTO 
     */
    public crearProveedor(provedorDTO: ProveedorDTO): Observable<any> {
        return this.httpClient.post("http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crearProveedor", ProveedorDTO);
    }


    /**
     * @description Metodo encargado de invocar el servicio REST de modificar proveedor
     * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
     * @param idProveedor 
     * @param nombre 
     * @param montoCredito 
     */
    public modificarProveedor(idProveedor: number, nombre: string, montoCredito: number): Observable<any> {
        return this.httpClient.post("http://localhost:8085/semillero-servicios/rest/GestionarProveedor/modificarProveedor", {
            "idProveedor": idProveedor,
            "nombreProveedor": nombre,
            "montoCredito": montoCredito
        });
    }

    /**
     * @description Metodo encargado de invocar el servicio REST de cambiar el estado del proveedor
     * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
     * @param idProveedor 
     * @param estado 
     */
    public cambiarEstadoProveedor(idProveedor: number, estado: string): Observable<any> {
        return this.httpClient.post("http://localhost:8085/semillero-servicios/rest/GestionarProveedor/cambiarEstadoProveedor", {
            "idProveedor": idProveedor,
            "estadoNuevo": estado
        });
    }

    /**
     * @description Metodo encargado de invocar el servicio REST consultar proveedores
     * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
     */
    public consultarProveedores(): Observable<any> {
        return this.httpClient.get("http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedores");
    }

}