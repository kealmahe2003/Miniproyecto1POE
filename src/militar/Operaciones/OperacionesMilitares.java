package militar.Operaciones;


//aqui se asignan las misiones y se las almacena para luego ponerlas en los soldados y quede guardado 
public interface OperacionesMilitares {

    void asignarMision(String Mision); //Asigna una misión al soldado.
    String reportarEstado(); //Reporta el estado actual del soldado en relación a la misión. 

}
