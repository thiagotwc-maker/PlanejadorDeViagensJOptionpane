package planejadordeviagem;

import java.time.format.DateTimeFormatter;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

public class PlanejadorDeViagem {

    public static void main(String[] args) {
        menu();
        opcoes();
    }

    // Aqui e uma função com o menu inicial.
    public static void menu() {
        String[] opcoes = {"Realizar Viagem", "Sair"};
        int selecao = JOptionPane.showOptionDialog(null, "Escolha Uma Opção", "CVC Turismo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (selecao == 1) {
            System.exit(0);
        }
    }

    // Metodo com todas as verificações e condições
    public static void opcoes() {

        long dias = 0;
        String data = null;
        String nome = null;
        int dia = 0;
        double money = 0;

        // aqui recebe o nome do usuario.
        nome = JOptionPane.showInputDialog("Nome e Sobrenome");
        if (nome.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }

        // Aqui pega a data da viagem do usuario desde que seja válida.
        data = JOptionPane.showInputDialog("Data Da Viagem");
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            LocalDate dataFutura = LocalDate.parse(data, formato);
            LocalDate hoje = LocalDate.now();
            if(dataFutura.isAfter(hoje)){
                JOptionPane.showMessageDialog(null, "A Data é Passada.");  
            }else if(dataFutura.equals(hoje)){
                JOptionPane.showMessageDialog(null, "A Viagem é Hoje.");   
            }else{
                JOptionPane.showMessageDialog(null, "Faltem" +dias+ "Dias");
            }

            dias = ChronoUnit.DAYS.between(hoje, dataFutura);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Inválida: ");
        }

        if (data.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }
        
 

        
        
        String mes = JOptionPane.showInputDialog("Digite Quantos Dias Vai Viajar.");
        if(mes == null || mes.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo Vazio! ");    
        }else{
            dia = Integer.parseInt(mes.trim());
        }
        if(dia < 0){
            JOptionPane.showMessageDialog(null, "Não Pode Ter Dias Negativos!!!");
        }
                
        // Aqui pega a quantidade de dias que o usuario vai digitar.
        //Sring dia = JOptionPane.showInputDialog("Quantidade De Dias.");
        //numero = Integer.parseInt(dia);
        
        
  
        
        
        
        
        String valor = JOptionPane.showInputDialog("Digite O Valor Que Pretende Gastar.");
        if(valor == null || valor.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo Vazio! ");    
        }else{
            money = Double.parseDouble(valor.trim());
        }
        if(money < 0){           
            JOptionPane.showMessageDialog(null, "Não Pode Ter Válor Negativo!!! ");
        }
       
        
        // Aqui vai receber o valor que o usuario pretende gastar na viagem.
//        String valor = JOptionPane.showInputDialog("Valor Gasto Por Dia.");
//        rico = Double.parseDouble(valor);
//
//        if (valor.isBlank()) {
//            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
//        }
//        if (rico < 0) {
//            JOptionPane.showMessageDialog(null, "Numero inválido( numero negativo).");
//        }

        //Aqui exibe todos os dados coletados anteriormente.
        
        
        
        double resultado = dia * money;
        JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nData: " + data + "\nDias: " + dia + "\nValo Por Dia: " +money );

        JOptionPane.showMessageDialog(null, nome + "  Sua Viagem Será: " + data + "\nFaltam: " + dias + "\nO Custo Total É: " + resultado);
    }
}
