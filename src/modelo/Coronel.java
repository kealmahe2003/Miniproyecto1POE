package modelo;

public class Coronel extends Rango implements Persona{
    
        private String estrategia;
        private String id;
        private String nombre;
        private String rango;
    
        public Coronel (String estrategia){
            super(4);
            this.estrategia = estrategia;
        }
    
        public String getEstrategia() {
            return estrategia;
        }

        public void setEstrategia(String estrategia) {
            this.estrategia = estrategia;
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
            this.estrategia = cualidad;
        }

        @Override
        public String getCualidad() {
            return getEstrategia();
        }
    
}
