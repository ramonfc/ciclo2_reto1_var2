package main;

public class SIMCard {

    //Inserte acá los atributos

    private String empresaTelefonia;
    private double saldo;
    private String numeroTelefono;
    private boolean celularApagado;
    private boolean modoAvionActivado;
    private boolean datosActivados;
    private int saldoDatos;


    //Inserte acá el método constructor


    public SIMCard(String numeroTelefono) {
        this.empresaTelefonia = "HI";
        this.saldo = 0;
        this.numeroTelefono = numeroTelefono;
        this.celularApagado = true;
        this.modoAvionActivado = false;
        this.datosActivados = false;
        this.saldoDatos = 0;
    }



    //Inserte acá los métodos (NO LOS GETTER Y SETTERS)


    /**
     * Método no solicitado para validar si el costo calculado supera el saldo disponible
     * @param cantidad nuevo valor del saldo de datos
     * @param costo costo de la cantidad de datos comprados
     */

    private void puedeComprar(int cantidad, double costo){
        if(costo <= getSaldo()){
            saldo -= costo;
            saldoDatos += cantidad;
        }
    }

    public void comprarDatos(int c){
        double costo;
        if(c <= 10){
            costo= c*3000;
            puedeComprar(c, costo);
        }
        else if(c > 10 && c <= 30){
            costo = (10 * 3000) + (c - 10) * 2500;
            puedeComprar(c, costo);
        }
        else if(c > 30){
            costo = (20 * 3000) + (c - 20) * 1500;
            puedeComprar(c, costo);
        }
    }

    public void consumirDatos(int c){
        if (isCelularApagado() ||
                !isDatosActivados() ||
                isModoAvionActivado() ||
                (getSaldoDatos() <= 0)) {
            return;
        }
        saldoDatos -= c;
    }

    public void llamar(int s){
        if(isCelularApagado() || isModoAvionActivado() || getSaldo() <= 0) return;
        if( s <= 60) saldo -= s * 1;
        else if(s > 60) saldo -= 60 + (s - 60) * 0.5;

    }

    public void recargarSaldo(double s){
        setSaldo(getSaldo() + s);
    }

    public void gestionarEncendidoCelular(){
        if(isCelularApagado()){
            setCelularApagado(false);
        }else {
            setCelularApagado(true);
            setDatosActivados(false);
            setModoAvionActivado(false);
        }
    }
    public void gestionarModoAvion(){
        if(!isCelularApagado()) {
            if(!isModoAvionActivado()){
                setModoAvionActivado(true);
                setDatosActivados(false);
            }
            else {
                setModoAvionActivado(false);
                setDatosActivados(false);
            }
        }
    }
    public void gestionarDatos(){
        if(!isCelularApagado()){
            if(!isModoAvionActivado()){
                if(!isDatosActivados()){
                    setDatosActivados(true);
                }else {
                    setDatosActivados(false);
                }
            }
        }
    }



    //Inserte acá los SETTERS Y GETTERS



    public String getEmpresaTelefonia() {
        return empresaTelefonia;
    }

    public void setEmpresaTelefonia(String empresaTelefonia) {
        this.empresaTelefonia = empresaTelefonia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public boolean isCelularApagado() {
        return celularApagado;
    }

    public void setCelularApagado(boolean celularApagado) {
        this.celularApagado = celularApagado;
    }

    public boolean isModoAvionActivado() {
        return modoAvionActivado;
    }

    public void setModoAvionActivado(boolean modoAvionActivado) {
        this.modoAvionActivado = modoAvionActivado;
    }

    public boolean isDatosActivados() {
        return datosActivados;
    }

    public void setDatosActivados(boolean datosActivados) {
        this.datosActivados = datosActivados;
    }

    public int getSaldoDatos() {
        return saldoDatos;
    }

    public void setSaldoDatos(int saldoDatos) {
        this.saldoDatos = saldoDatos;
    }



    // OTHER METHODS:


    /**
     * Método no solicitado que permite mostrar en consola los datos del objeto
     * @return
     */
    @Override
    public String toString() {
        return "SIMCard{\n" +
                "empresaTelefonia= " + empresaTelefonia + "\n" +
                 "saldo= " + saldo + "\n" +
                "numeroTelefono= " + numeroTelefono + "\n" +
                "celularApagado= " + celularApagado + "\n" +
                "modoAvionActivado= " + modoAvionActivado +"\n" +
                "datosActivados= " + datosActivados + "\n" +
                "saldoDatos= " + saldoDatos + "\n" +
                '}';
    }
}
