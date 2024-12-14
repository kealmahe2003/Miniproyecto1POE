package modelo;

public class Capitan extends Rango implements Persona{
    
        private int cantSoldados;
        private String id;
        private String nombre;
        private String rango;

        public Capitan (int cantSoldados){
            super(3);
            this.cantSoldados = cantSoldados;
        }

        public String getCantSoldados() {
            return Integer.toString(cantSoldados);
        }

        public void setCantSoldados(int cantSoldados) {
            this.cantSoldados = cantSoldados;
        }

        @Override
        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String getNombre() {
            return nombre;
        }

        @Override
        public void setRango(String rango) {
            this.rango = rango;
        }

        @Override
        public String getRango() {
            return rango;
        }

        @Override
        public void setCualidad(String cualidad) {
            this.cantSoldados = Integer.parseInt(cualidad);
        }

        @Override
        public String getCualidad() {
            return getCantSoldados();
        }
}
