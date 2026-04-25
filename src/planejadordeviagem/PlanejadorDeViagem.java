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
        int numero = 0;
        double rico = 0;

        // aqui recebe o nome do usuario.
        nome = JOptionPane.showInputDialog("Nome e Sobrenome");
        if (nome.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }

        // Aqui pega a data da viagem do usuario desde que seja válida.
        data = JOptionPane.showInputDialog("Data Da Viagem");
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate converter = LocalDate.parse(data, formato);
            LocalDate dataFutura = LocalDate.parse(data, formato);
            LocalDate hoje = LocalDate.now();

            dias = ChronoUnit.DAYS.between(hoje, dataFutura);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Inválida: ");
        }

        if (data.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }

        // Aqui pega a quantidade de dias que o usuario vai digitar.
        String dia = JOptionPane.showInputDialog("Quantidade De Dias.");
        numero = Integer.parseInt(dia);

        if (dia.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }
        if (numero < 0) {
            JOptionPane.showMessageDialog(null, "Numero inválido( numero negativo).");
        }

        // Aqui vai receber o valor que o usuario pretende gastar na viagem.
        String valor = JOptionPane.showInputDialog("Valor Gasto Por Dia.");
        rico = Double.parseDouble(valor);

        if (valor.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }
        if (rico < 0) {
            JOptionPane.showMessageDialog(null, "Numero inválido( numero negativo).");
        }

        //Aqui exibe todos os dados coletados anteriormente.
        JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nData: " + data + "\nDias: " + numero + "\nValo Por Dia: " + rico);

        double resultado = numero * rico;
        JOptionPane.showMessageDialog(null, nome + "  Sua Viagem Será: " + data + "\nFaltam: " + dias + "\nO Custo Total É: " + resultado);
    }
}
