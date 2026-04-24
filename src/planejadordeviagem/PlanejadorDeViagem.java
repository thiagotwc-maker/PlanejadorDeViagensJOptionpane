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

    public static void menu() {
        String[] opcoes = {"Realizar Viagem", "Sair"};
        int selecao = JOptionPane.showOptionDialog(null, "Escolha Uma Opção", "CVC Turismo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (selecao == 1) {
            System.exit(0);
        }
    }

    public static void opcoes() {

        String nome = JOptionPane.showInputDialog("Nome e Sobrenome");
        if (nome.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }
        
        
        
        String data = JOptionPane.showInputDialog("Data Da Viagem");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate converter = LocalDate.parse(data, formato);
        LocalDate dataFutura = LocalDate.parse(data, formato);
        
        LocalDate hoje = LocalDate.now();
        long dias = ChronoUnit.DAYS.between(hoje, dataFutura);

        JOptionPane.showMessageDialog(null, "Data Inválida: " + data);

        if (data.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }
        
        

        String dia = JOptionPane.showInputDialog("Quantidade De Dias.");
        int numero = Integer.parseInt(dia);

        if (dia.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }
        if (numero < 0) {
            JOptionPane.showMessageDialog(null, "Numero inválido( numero negativo).");
        }
        

        String valor = JOptionPane.showInputDialog("Valor Gasto Por Dia.");
        double rico = Double.parseDouble(valor);

        if (valor.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }
        if (rico < 0) {
            JOptionPane.showMessageDialog(null, "Numero inválido( numero negativo).");
        }
        
        
        JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nData: " + data + "\nDias: " + numero + "\nValo Por Dia: " + rico);

        double resultado = numero * rico;
        JOptionPane.showMessageDialog(null, nome + "Sua Viagem Será: " + data + "\nFaltam: " + dias + "\nO Custo Total É: " + resultado);
    }
}
