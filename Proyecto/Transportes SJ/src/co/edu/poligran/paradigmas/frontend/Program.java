package co.edu.poligran.paradigmas.frontend;

import java.util.*;
import co.edu.poligran.paradigmas.backend.vo.*;
import co.edu.poligran.paradigmas.backend.negocio.*;

public class Program {
    static Scanner sc = new Scanner(System.in);

    static PasajeroManager pm = new PasajeroManager();
    static VehiculoManager vm = new VehiculoManager();
    static HorarioManager hm = new HorarioManager();
    static RutaManager rm = new RutaManager();
    static ParadaManager pam = new ParadaManager();
    static BoletoManager bm = new BoletoManager();
    static AsientoManager am = new AsientoManager();

    static List<PersonaVO> personas = new ArrayList<>();
    static List<EmpleadoVO> empleados = new ArrayList<>();
    static List<ConductorVO> conductores = new ArrayList<>();

    public static void main(String[] args){

        int op;

        do{
            System.out.println("\nTRANSPORTES SJ");
            System.out.println("1. Pasajeros");
            System.out.println("2. Vehiculos");
            System.out.println("3. Horarios");
            System.out.println("4. Rutas");
            System.out.println("5. Paradas");
            System.out.println("6. Boletos");
            System.out.println("7. Asientos");
            System.out.println("8. Personas");
            System.out.println("9. Empleados");
            System.out.println("10. Conductores");
            System.out.println("0. Salir");

            op = leerInt("Seleccione una opcion: ");

            try{
                switch(op){
                    case 1: crudPasajero(); break;
                    case 2: crudVehiculo(); break;
                    case 3: crudHorario(); break;
                    case 4: crudRuta(); break;
                    case 5: crudParada(); break;
                    case 6: crudBoleto(); break;
                    case 7: crudAsiento(); break;
                    case 8: crudPersona(); break;
                    case 9: crudEmpleado(); break;
                    case 10: crudConductor(); break;
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }

        }while(op != 0);
    }

    static int leerInt(String msg){
        while(true){
            try{
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("Entrada invalida");
            }
        }
    }

    static double leerDouble(String msg){
        while(true){
            try{
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            }catch(Exception e){
                System.out.println("Entrada invalida");
            }
        }
    }

    static String leerStr(String msg){
        System.out.print(msg);
        return sc.nextLine();
    }

    static String leerTexto(String msg){
        System.out.print(msg);
        return sc.nextLine();
    }

    // ================= PASAJERO =================
    static void crudPasajero() throws Exception{
        int op;
        do{
            System.out.println("\n PASAJEROS ");
            System.out.println("\n 1.Crear\n 2.Mostrar\n 3.Buscar \n 4.Actualizar \n 5.Eliminar \n 0.Volver");

            op = leerInt("Opcion: ");

            switch(op){
                case 1:
                    int id = leerInt("ID: ");
                    if(pm.buscar(id)!=null) throw new Exception("Duplicado");
                    pm.crear(new PasajeroVO(id, leerStr("Nombre: "), leerStr("Documento: "), leerStr("Telefono: ")));
                    System.out.println("Pasajero creado");
                    break;

                case 2:
                    if(pm.listar().isEmpty()) throw new Exception("Sin datos");
                    pm.listar().forEach(p->System.out.println(p.getId()+" "+p.getNombre()+" "+p.getDocumento()));
                    break;

                case 3:
                    PasajeroVO p = pm.buscar(leerInt("ID: "));
                    if(p==null) throw new Exception("No existe");
                    System.out.println("Encontrado: "+p.getNombre());
                    break;

                case 4:
                    PasajeroVO pa = pm.buscar(leerInt("ID: "));
                    if(pa==null) throw new Exception("No existe");
                    pa.setNombre(leerStr("Nuevo nombre: "));
                    pa.setDocumento(leerStr("Documento: "));
                    pa.setTelefono(leerStr("Telefono: "));
                    System.out.println("Actualizado");
                    break;

                case 5:
                    int idE = leerInt("ID: ");
                    if(pm.buscar(idE)==null) throw new Exception("No existe");
                    pm.eliminar(idE);
                    System.out.println("Eliminado");
                    break;
            }

        }while(op!=0);
    }

    // ================= VEHICULO =================
    static void crudVehiculo() throws Exception{
        int op;
        do{
            System.out.println("\n VEHICULOS ");
            System.out.println("\n 1.Crear\n 2.Mostrar\n 3.Buscar \n 4.Actualizar \n 5.Eliminar \n 0.Volver");

            op = leerInt("Opcion: ");

            switch(op){
                case 1:
                    int id = leerInt("ID: ");
                    if(vm.buscar(id)!=null) throw new Exception("Duplicado");
                    vm.crear(new VehiculoVO(id, leerInt("Capacidad: "), leerStr("Placa: "), leerStr("Modelo: ")));
                    System.out.println("Vehiculo creado");
                    break;

                case 2:
                    vm.listar().forEach(v->System.out.println(v.getId()+" "+v.getPlaca()));
                    break;

                case 3:
                    VehiculoVO v = vm.buscar(leerInt("ID: "));
                    if(v==null) throw new Exception("No existe");
                    System.out.println("Encontrado: "+v.getPlaca());
                    break;

                case 4:
                    VehiculoVO va = vm.buscar(leerInt("ID: "));
                    if(va==null) throw new Exception("No existe");
                    va.setCapacidad(leerInt("Capacidad: "));
                    va.setPlaca(leerStr("Placa: "));
                    va.setModelo(leerStr("Modelo: "));
                    System.out.println("Actualizado");
                    break;

                case 5:
                    int idE = leerInt("ID: ");
                    vm.eliminar(idE);
                    System.out.println("Eliminado");
                    break;
            }

        }while(op!=0);
    }

    // ================= HORARIO =================
    static void crudHorario() throws Exception{
        int op;
        do{
            System.out.println("\n HORARIOS ");
            System.out.println("\n 1.Crear\n 2.Mostrar\n 3.Buscar \n 4.Actualizar \n 5.Eliminar \n 0.Volver");

            op = leerInt("Opcion: ");

            switch(op){
                case 1:
                    int id = leerInt("ID: ");
                    hm.crear(new HorarioVO(id, leerStr("Salida: "), leerStr("Llegada: "), leerStr("Dia: ")));
                    System.out.println("Creado");
                    break;

                case 2:
                    hm.listar().forEach(h->System.out.println(h.getId()+" "+h.getDia()));
                    break;

                case 3:
                    HorarioVO h = hm.buscar(leerInt("ID: "));
                    if(h==null) throw new Exception("No existe");
                    System.out.println("Encontrado");
                    break;

                case 4:
                    HorarioVO ha = hm.buscar(leerInt("ID: "));
                    if(ha==null) throw new Exception("No existe");
                    ha.setDia(leerStr("Dia: "));
                    System.out.println("Actualizado");
                    break;

                case 5:
                    hm.eliminar(leerInt("ID: "));
                    System.out.println("Eliminado");
                    break;
            }

        }while(op!=0);
    }

    // ================= RUTA =================
    static void crudRuta() throws Exception{
        int op;
        do{
            System.out.println("\n RUTAS ");
            System.out.println("\n 1.Crear\n 2.Mostrar\n 3.Buscar \n 4.Actualizar \n 5.Eliminar \n 0.Volver");

            op = leerInt("Opcion: ");

            switch(op){
                case 1:
                    int id = leerInt("ID: ");
                    RutaVO r = new RutaVO(id, leerStr("Origen: "), leerStr("Destino: "),
                            hm.buscar(leerInt("Horario: ")),
                            vm.buscar(leerInt("Vehiculo: "))
                    );
                    rm.crear(r);
                    System.out.println("Creado");
                    break;

                case 2:
                    rm.listar().forEach(x->System.out.println(x.getId()+" "+x.getOrigen()));
                    break;

                case 3:
                    RutaVO rb = rm.buscar(leerInt("ID: "));
                    if(rb==null) throw new Exception("No existe");
                    System.out.println(rb.getOrigen());
                    break;

                case 4:
                    RutaVO ra = rm.buscar(leerInt("ID: "));
                    if(ra==null) throw new Exception("No existe");
                    ra.setOrigen(leerStr("Origen: "));
                    System.out.println("Actualizado");
                    break;

                case 5:
                    rm.eliminar(leerInt("ID: "));
                    System.out.println("Eliminado");
                    break;
            }

        }while(op!=0);
    }

    // ================= PARADA =================
    static void crudParada() throws Exception{
        int op;
        do{
            System.out.println("\n PARADAS ");
            System.out.println("\n 1.Crear\n 2.Mostrar\n 3.Buscar \n 4.Actualizar \n 5.Eliminar \n 0.Volver");

            op = leerInt("Opcion: ");

            switch(op){
                case 1:
                    pam.crear(new ParadaVO(leerInt("ID: "), leerStr("Nombre: "), leerStr("Ubicacion: ")));
                    System.out.println("Creado");
                    break;

                case 2:
                    pam.listar().forEach(p->System.out.println(p.getNombre()));
                    break;

                case 3:
                    ParadaVO pb = pam.buscar(leerInt("ID: "));
                    if(pb==null) throw new Exception("No existe");
                    System.out.println(pb.getNombre());
                    break;

                case 4:
                    ParadaVO pa = pam.buscar(leerInt("ID: "));
                    if(pa==null) throw new Exception("No existe");
                    pa.setUbicacion(leerStr("Ubicacion: "));
                    System.out.println("Actualizado");
                    break;

                case 5:
                    pam.eliminar(leerInt("ID: "));
                    System.out.println("Eliminado");
                    break;
            }

        }while(op!=0);
    }

    // ================= BOLETO =================
    static void crudBoleto() throws Exception {
        int op;
        do {
            System.out.println("\n BOLETOS ");
            System.out.println("\n 1.Crear\n 2.Mostrar\n 3.Buscar \n 4.Actualizar \n 5.Eliminar \n 0.Volver");

            op = leerInt("Opcion: ");

            switch(op) {
                case 1:
                    int id = leerInt("ID: ");
                    if (bm.buscar(id) != null) throw new Exception("Duplicado");

                    double precio = leerDouble("Precio: ");
                    String fecha = leerTexto("Fecha: ");

                    PasajeroVO pasajero = pm.buscar(leerInt("ID Pasajero: "));
                    RutaVO ruta = rm.buscar(leerInt("ID Ruta: "));
                    AsientoVO asiento = am.buscar(leerInt("ID Asiento: "));

                    if (pasajero == null) throw new Exception("Pasajero no existe");
                    if (ruta == null) throw new Exception("Ruta no existe");
                    if (asiento == null) throw new Exception("Asiento no existe");

                    BoletoVO nuevo = new BoletoVO(id, precio, fecha, pasajero, ruta, asiento);
                    bm.crear(nuevo);
                    System.out.println("Boleto creado");
                    break;

                case 2:
                    if (bm.listar().isEmpty()) throw new Exception("Sin datos");
                    bm.listar().forEach(b ->
                            System.out.println(
                                    "ID: " + b.getId() +
                                            ", Precio: " + b.getPrecio() +
                                            ", Fecha: " + b.getFecha()
                            )
                    );
                    break;

                case 3:
                    BoletoVO encontrado = bm.buscar(leerInt("ID: "));
                    if(encontrado == null) throw new Exception("Boleto no existe");
                    System.out.println(
                            "ID: " + encontrado.getId() +
                                    ", Precio: " + encontrado.getPrecio() +
                                    ", Fecha: " + encontrado.getFecha()
                    );
                    break;

                case 4:
                    int idAct = leerInt("ID del boleto a actualizar: ");
                    BoletoVO existente = bm.buscar(idAct);
                    if(existente == null) throw new Exception("Boleto no existe");

                    double precioAct = leerDouble("Nuevo precio: ");
                    String fechaAct = leerTexto("Nueva fecha: ");

                    PasajeroVO pasajeroAct = pm.buscar(leerInt("Nuevo ID Pasajero: "));
                    RutaVO rutaAct = rm.buscar(leerInt("Nuevo ID Ruta: "));
                    AsientoVO asientoAct = am.buscar(leerInt("Nuevo ID Asiento: "));

                    if (pasajeroAct == null) throw new Exception("Pasajero no existe");
                    if (rutaAct == null) throw new Exception("Ruta no existe");
                    if (asientoAct == null) throw new Exception("Asiento no existe");

                    BoletoVO actualizado = new BoletoVO(idAct, precioAct, fechaAct, pasajeroAct, rutaAct, asientoAct);
                    bm.actualizar(actualizado);
                    System.out.println("Boleto actualizado");
                    break;

                case 5:
                    int idE = leerInt("ID: ");
                    if(bm.buscar(idE) == null) throw new Exception("Boleto no existe");
                    bm.eliminar(idE);
                    System.out.println("Eliminado");
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while(op != 0);
    }

    // ================= ASIENTO =================
    static void crudAsiento() throws Exception{
        int op;
        do{
            System.out.println("\n ASIENTOS ");
            System.out.println("\n 1.Crear\n 2.Mostrar\n 3.Buscar \n 4.Actualizar \n 5.Eliminar \n 0.Volver");

            op = leerInt("Opcion: ");

            switch(op){
                case 1:
                    am.crear(new AsientoVO(leerInt("Numero: ")));
                    System.out.println("Creado");
                    break;

                case 2:
                    am.listar().forEach(a->System.out.println(a.getNumero()));
                    break;

                case 3:
                    AsientoVO ab = am.buscar(leerInt("Numero: "));
                    if(ab==null) throw new Exception("No existe");
                    System.out.println(ab.getNumero());
                    break;

                case 4:
                    AsientoVO a = am.buscar(leerInt("Numero: "));
                    if(a==null) throw new Exception("No existe");
                    a.setOcupado(!a.isOcupado());
                    System.out.println("Actualizado");
                    break;

                case 5:
                    am.eliminar(leerInt("Numero: "));
                    System.out.println("Eliminado");
                    break;
            }

        }while(op!=0);
    }

    // ================= PERSONA =================
    static void crudPersona(){
        int op;
        do{
            System.out.println("\n PERSONAS ");
            System.out.println("\n 1.Crear\n 2.Mostrar\n 3.Buscar \n 4.Actualizar \n 5.Eliminar \n 0.Volver");

            op = leerInt("Opcion: ");

            switch(op){
                case 1:
                    int id = leerInt("ID: ");
                    if(buscarPersona(id) != null){
                        System.out.println("Persona duplicada");
                        break;
                    }

                    personas.add(new PersonaVO(id, leerStr("Nombre: ")));
                    System.out.println("Creado");
                    break;

                case 2:
                    if(personas.isEmpty()){
                        System.out.println("Sin datos");
                    } else {
                        personas.forEach(p ->
                                System.out.println("ID: " + p.getId() + " Nombre: " + p.getNombre())
                        );
                    }
                    break;

                case 3:
                    PersonaVO p = buscarPersona(leerInt("ID: "));
                    if(p == null){
                        System.out.println("No existe");
                    } else {
                        System.out.println("ID: " + p.getId());
                        System.out.println("Nombre: " + p.getNombre());
                    }
                    break;

                case 4:
                    PersonaVO pa = buscarPersona(leerInt("ID: "));
                    if(pa == null){
                        System.out.println("No existe");
                    } else {
                        pa.setNombre(leerStr("Nuevo nombre: "));
                        System.out.println("Actualizado");
                    }
                    break;

                case 5:
                    PersonaVO pe = buscarPersona(leerInt("ID: "));
                    if(pe == null){
                        System.out.println("No existe");
                    } else {
                        personas.remove(pe);
                        System.out.println("Eliminado");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        }while(op != 0);
    }

    static PersonaVO buscarPersona(int id){
        for(PersonaVO p : personas){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    // ================= EMPLEADO =================
    static void crudEmpleado(){
        int op;
        do{
            System.out.println("\n EMPLEADOS ");
            System.out.println("\n 1.Crear\n 2.Mostrar\n 3.Buscar \n 4.Actualizar \n 5.Eliminar \n 0.Volver");

            op = leerInt("Opcion: ");

            switch(op){
                case 1:
                    int id = leerInt("ID: ");
                    if(buscarEmpleado(id) != null){
                        System.out.println("Empleado duplicado");
                        break;
                    }

                    empleados.add(new EmpleadoVO(
                            id,
                            leerStr("Nombre: "),
                            leerDouble("Salario: "),
                            leerStr("Cargo: ")
                    ));
                    System.out.println("Creado");
                    break;

                case 2:
                    if(empleados.isEmpty()){
                        System.out.println("Sin datos");
                    } else {
                        empleados.forEach(e ->
                                System.out.println(
                                        "ID: " + e.getId() +
                                                " Nombre: " + e.getNombre() +
                                                " Salario: " + e.getSalario() +
                                                " Cargo: " + e.getCargo()
                                )
                        );
                    }
                    break;

                case 3:
                    EmpleadoVO e = buscarEmpleado(leerInt("ID: "));
                    if(e == null){
                        System.out.println("No existe");
                    } else {
                        System.out.println("ID: " + e.getId());
                        System.out.println("Nombre: " + e.getNombre());
                        System.out.println("Salario: " + e.getSalario());
                        System.out.println("Cargo: " + e.getCargo());
                    }
                    break;

                case 4:
                    EmpleadoVO ea = buscarEmpleado(leerInt("ID: "));
                    if(ea == null){
                        System.out.println("No existe");
                    } else {
                        ea.setNombre(leerStr("Nuevo nombre: "));
                        ea.setSalario(leerDouble("Nuevo salario: "));
                        ea.setCargo(leerStr("Nuevo cargo: "));
                        System.out.println("Actualizado");
                    }
                    break;

                case 5:
                    EmpleadoVO ee = buscarEmpleado(leerInt("ID: "));
                    if(ee == null){
                        System.out.println("No existe");
                    } else {
                        empleados.remove(ee);
                        System.out.println("Eliminado");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        }while(op!=0);
    }

    static EmpleadoVO buscarEmpleado(int id){
        for(EmpleadoVO e : empleados){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }

    // ================= CONDUCTOR =================
    static void crudConductor(){
        int op;
        do{
            System.out.println("\n CONDUCTORES ");
            System.out.println("\n 1.Crear\n 2.Mostrar\n 3.Buscar \n 4.Actualizar \n 5.Eliminar \n 0.Volver");

            op = leerInt("Opcion: ");

            switch(op){
                case 1:
                    int id = leerInt("ID: ");
                    if(buscarConductor(id) != null){
                        System.out.println("Conductor duplicado");
                        break;
                    }

                    conductores.add(new ConductorVO(
                            id,
                            leerStr("Nombre: "),
                            leerDouble("Salario: "),
                            leerStr("Cargo: "),
                            leerStr("Licencia: "),
                            leerInt("Experiencia: ")
                    ));
                    System.out.println("Creado");
                    break;

                case 2:
                    if(conductores.isEmpty()){
                        System.out.println("Sin datos");
                    } else {
                        conductores.forEach(c ->
                                System.out.println(
                                        "ID: " + c.getId() +
                                                " Nombre: " + c.getNombre() +
                                                " Cargo: " + c.getCargo() +
                                                " Licencia: " + c.getLicencia() +
                                                " Experiencia: " + c.getExperiencia()
                                )
                        );
                    }
                    break;

                case 3:
                    ConductorVO c = buscarConductor(leerInt("ID: "));
                    if(c == null){
                        System.out.println("No existe");
                    } else {
                        System.out.println("ID: " + c.getId());
                        System.out.println("Nombre: " + c.getNombre());
                        System.out.println("Salario: " + c.getSalario());
                        System.out.println("Cargo: " + c.getCargo());
                        System.out.println("Licencia: " + c.getLicencia());
                        System.out.println("Experiencia: " + c.getExperiencia());
                    }
                    break;

                case 4:
                    ConductorVO ca = buscarConductor(leerInt("ID: "));
                    if(ca == null){
                        System.out.println("No existe");
                    } else {
                        ca.setNombre(leerStr("Nuevo nombre: "));
                        ca.setSalario(leerDouble("Nuevo salario: "));
                        ca.setCargo(leerStr("Nuevo cargo: "));
                        ca.setLicencia(leerStr("Nueva licencia: "));
                        ca.setExperiencia(leerInt("Nueva experiencia: "));
                        System.out.println("Actualizado");
                    }
                    break;

                case 5:
                    ConductorVO ce = buscarConductor(leerInt("ID: "));
                    if(ce == null){
                        System.out.println("No existe");
                    } else {
                        conductores.remove(ce);
                        System.out.println("Eliminado");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        }while(op!=0);
    }

    static ConductorVO buscarConductor(int id){
        for(ConductorVO c : conductores){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
}