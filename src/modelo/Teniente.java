package modelo;

public class Teniente extends Rango implements Persona{
    
        private String unidad;
        private String id;
        private String nombre;
        private String rango;


        public Teniente(String unidad){
            super(2);
            this.unidad = unidad;
        }

        public String getUnidad() {
            return unidad;
        }

        public void setUnidad(int unidad) {
            unidad = unidad;
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
            this.unidad = cualidad;
        }

        @Override
        public String getCualidad() {
            return getUnidad();
        }

}
