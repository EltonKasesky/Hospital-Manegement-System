package main;

public class Billing {
    int consulted;
    int consultationValue;
    int inpatient;
    int inpatientValue;

    public Billing(int consulted, int consultationValue, int inpatient, int inpatientValue){
        this.consulted = consulted;
        this.consultationValue = consultationValue;
        this.inpatient = inpatient;
        this.inpatientValue = inpatientValue;
    }

    public int getInpatientValue() {
        return inpatientValue;
    }

    public void setInpatientValue(int inpatientValue) {
        this.inpatientValue = inpatientValue;
    }

    public int getInpatient() {
        return inpatient;
    }

    public void setInpatient(int inpatient) {
        this.inpatient = inpatient;
    }

    public int getConsultationValue() {
        return consultationValue;
    }

    public void setConsultationValue(int consultationValue) {
        this.consultationValue = consultationValue;
    }

    public int getConsulted() {
        return consulted;
    }

    public void setConsulted(int consulted) {
        this.consulted = consulted;
    }

    public void DisplayBilling(){
        System.out.println("Quantidade de pessoas que foram internadas: " + inpatient);
        System.out.println("Quantidade de pessoas que foram consultadas: " + consulted);
        System.out.println("Receita proveniente de internações: R$" + inpatientValue);
        System.out.println("Receita proveniente de consultas: R$" + consultationValue);
        System.out.println("Receita total do hospital XPTO: R$" + (consultationValue + inpatientValue));
    }
}