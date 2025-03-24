package main;
import java.util.Scanner;

/**
 * @author Elton Kasesky
 * @since 23-03-2025
 */

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean loop = true;

        InpatientRoom[] inpatientRooms = new InpatientRoom[20];
        InicializeInpatientRooms(inpatientRooms);

        Billing billing = new Billing(0,0,0,0);

        do{
            Menu();
            System.out.print("Digite qual opção voce deseja: ");
            byte option = scanner.nextByte();

            switch(option){
                case 1:
                    InsertConsultation(billing);
                    break;
                case 2:
                    InsertInpatient(inpatientRooms, billing);
                    break;
                case 3:
                    ListInpatientRooms(inpatientRooms);
                    break;
                case 4:
                    billing.DisplayBilling();
                    break;
                case 5:
                    loop = false;
                    scanner.close();
                    break;
            }
        }while(loop);
    }

    private static void Menu(){
        System.out.println("HOSPITAL - XPTO\n---------------------------------- ");
        System.out.println("1 -> Consulta Ambolatorial");
        System.out.println("2 -> Internação");
        System.out.println("3 -> Listar Quartos");
        System.out.println("4 -> Faturamento");
        System.out.println("5 -> Sair do Programa");
    }

    private static void InicializeInpatientRooms(InpatientRoom[] inpatientRooms){
        for(int i = 0; i < 20; i++){
            String[] status = {"Desocupado"};
            String[] name = {"Nome do paciente"};
            String[] tel = {"Telefone do paciente"};

            inpatientRooms[i] = new InpatientRoom(status, name, tel);
        }
    }

    private static void ListInpatientRooms(InpatientRoom[] inpatientRooms){
        for(int i = 0; i < inpatientRooms.length; i++){
            String status = inpatientRooms[i].getInpatienteRoomStatus()[0];
            String name = inpatientRooms[i].getInpatienteRoomsName()[0];
            String tel = inpatientRooms[i].getInpatienteRoomsTel()[0];

            System.out.println((i+1) + "º Quarto:   Status: " + status + "   Nome: " + name + "   Telefone: " + tel);
        }
        System.out.println("\n");
    }

    private static void InsertInpatient(InpatientRoom[] inpatientRooms, Billing billing){
        System.out.print("Qual quarto deseja realizar a internação: ");
        byte room = scanner.nextByte();

        String status = inpatientRooms[room-1].getInpatienteRoomStatus()[0];

        if (status.equalsIgnoreCase("Desocupado")){
            System.out.print("Informe o nome do paciente a ser internado: ");
            String name = scanner.next();

            if(!name.isEmpty()){
                System.out.print("Informe o número de telefone do paciente " + name + ": ");
                String tel = scanner.next();

                if(!tel.isEmpty()){
                    inpatientRooms[room -1].getInpatienteRoomStatus()[0] = "Ocupado";
                    inpatientRooms[room -1].getInpatienteRoomsName()[0] = name;
                    inpatientRooms[room -1].getInpatienteRoomsTel()[0] = tel;
                    billing.setInpatient(billing.getInpatient() + 1);
                    billing.setInpatientValue(billing.getInpatientValue() + 500);

                    System.out.println("O paciente " + name + " foi internado com sucesso!");
                } else {
                    System.out.println("Digite um telefone valido para a internação do paciente " + name);
                }
            } else {
                System.out.println("Digite um nome valido para a internação do paciente!");
            }
        } else {
            System.out.println("O quarto nº" + room + " esta ocupado! Tente outro quarto.");
        }
    }

    private static void InsertConsultation(Billing billing){
        System.out.print("Qual o nome do paciente a ser consultado: ");
        String name = scanner.next();

        if(!name.isEmpty()){
            System.out.print("Qual o número de telefone do paciente " + name + ": ");
            String tel = scanner.next();

            if(!tel.isEmpty()){
                System.out.print("Qual a especialidade da consulta: ");
                String specialty = scanner.next();

                if(specialty.equalsIgnoreCase("Pediatria")){
                    System.out.println("A consulta para o(a) paciente " + name + " foi marcada para a especialidade de pediatria\nO custo da consulta é de R$150");
                    billing.setConsulted(billing.getConsulted() + 1);
                    billing.setConsultationValue(billing.getConsultationValue() + 150);
                } else {
                    System.out.println("A consulta para o(a) paciente " + name + " foi marcada para a especialidade de " + specialty + "\nO custo da consulta é de R$120");
                    billing.setConsulted(billing.getConsulted() + 1);
                    billing.setConsultationValue((billing.getConsultationValue() + 120));
                }
            } else {
                System.out.println("Digite um telefone valido para a consulta do paciente " + name);
            }
        } else {
            System.out.println("Digite um nome valido para a consulta do paciente!");
        }
    }
}