package modelo;

public abstract class Rango implements Persona{
    private int nivel;
    private String rango;

    public Rango (int nivel){
        this.nivel = nivel;

    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (rango.equals("Soldado Raso")){
            nivel = 1;
        }
        if (rango.equals("Teniente")){
            nivel = 2;
        }
        if (rango.equals("Capitán")){
            nivel = 3;
        }
        if (rango.equals("Coronel")){
            nivel = 4;
        }
    }
}
