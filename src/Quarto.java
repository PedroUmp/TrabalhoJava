public class Quarto implements Interface {

    //Atributos
    private int numero;
    private boolean ocupado;
    private String ocupante;


    //Construtores

    public Quarto(int numero, String ocupante) {
        this.numero = numero;
        this.ocupado = true;
        this.ocupante = ocupante;
    }
    public Quarto() {

    }

    public Quarto(int numero) {
        this.numero = numero;
        this.ocupado = false;
    }


    //Getters e Setters
    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public String getOcupante() {
        return ocupante;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setOcupante(String ocupante) {
        this.ocupante = ocupante;
    }


    //Métodos
    public void imprimeObjeto() {
        System.out.println("Número do Quarto: " + numero);

        if(ocupado) {
            System.out.println("Quarto ocupado por: " + ocupante + "\n");
        }
        else {
            System.out.println("Quarto livre \n");
        }
    }

    public boolean compara(Object objeto, int tipo) {
        if(tipo==1) {
            return numero == (Integer) objeto;
        }
        else if(tipo==2) {
            return ocupante == objeto;
        }
        else{
            return ocupado == (boolean) objeto;
        }
    }
    @Override
    public boolean equals(Object objeto) {
        return ocupante == objeto;
    }

}
