import {Component, OnInit} from '@angular/core'

@Component({
    selector: 'crear-persona',
    templateUrl: './crear-persona-component.html'
})

export class CrearPersonaComponent implements OnInit{
    //tipo de listas.
    public listaApellidos : Array<any>
    public listaNombres = [];


    ngOnInit(): void {
        this.listaApellidos = new Array<any>();
        let mivariable: any = {
            id: 1,
            nombre: "Yonnatan",
            direccion : "Carrera 20"
        };
        mivariable.genero = "Masculino"
        mivariable.edad = 20
        //number-> acepta todo tipo de dato numerico.
        let variableNumber: number = 102.2;
        //string->permite hacer mejor las comparaciones.
        let variableString : string = "semillero2019";

        this.listaApellidos.push(mivariable);

        //alert("Tamaño de la lista: "+ this.listaNombres.length);
        this.inicializarComponente();

        let miMapa : Map<string,string>;
        miMapa = new Map<string, string>();
        miMapa.set("1", "semillero");
        miMapa.get("1");

        let miFecha = new Date();
    }


    public inicializarComponente() : Array<string> {
        let retorno : any;
        let objeto = undefined;
        if(objeto !== null){
            console.log("No es nulo");
            alert("no es nulo");
        } else {
            console.log("Si es nulo");
            alert("si es nulo")
        }
 
        console.log(1 == 1);
        console.log("1" == 1);
        console.log(1 === 1);
        console.log("1" === 1);
        return retorno;
    }


    public ejecucionEventoClick(parametroEvento: any): void{
        
    }



}
