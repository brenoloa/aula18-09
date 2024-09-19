public class Carro {
    private String modelo;
    private String marca;
    private boolean ligado;
    private double km;
    private boolean parado = true;
    
    
    
    public Carro(String modelo, String marca, double km) {
        this.modelo = modelo;
        this.marca = marca;
        this.km = km;
        this.ligado = false;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public boolean getLigado() {
        return ligado;
    }
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    public double getKm() {
        return km;
    }
    public void setKm(double km) {
        this.km = km;
    }

    
    
    public void acelerar(){
        if (this.parado == true){
            System.out.println("Carro ACELERANDO!");
            this.parado = false;
        }
        else {
            System.out.println("Ja acelerou!, freie antes de acelerar");
        }
    }
    public void frear(){
        if (this.parado == false){
            System.out.println("Carro FREANDO!");
            this.parado = true;
        }
        else {
            System.out.println("Carro ja está parado.");
        }
    }


    public void ligar(){
        if (this.ligado == false){
            System.out.println("carro ligado");
            this.ligado = true;
        }
        else if (this.ligado == true){
            System.out.println("carro desligado");
            this.ligado = false;
        }
            
    }
    


}
