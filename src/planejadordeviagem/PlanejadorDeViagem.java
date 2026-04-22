package planejadordeviagem;

import javax.swing.JOptionPane;

public class PlanejadorDeViagem {

    public static void main(String[] args) {
        menu();
        opcoes();
        
    }  

    public static void menu() {
        String[] opcoes = {"Realizar Viagem", "Sair"};
        int selecao = JOptionPane.showOptionDialog(null, "Escolha Uma Opção", "CVC Turismo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
    }

    public static void opcoes() {
        String nome = JOptionPane.showInputDialog("Nome e Sobrenome");
        if (nome.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }

        String data = JOptionPane.showInputDialog("Data Da Viagem");
        if (data.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }

        String dia = JOptionPane.showInputDialog("Quanntidade De Dias");
        if (dia.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }

        String valor = JOptionPane.showInputDialog("Valor Gasto Por Dia");
        if (valor.isBlank()) {
            JOptionPane.showMessageDialog(null, "Não Pode Estar Vazio.");
        }

    }
}
