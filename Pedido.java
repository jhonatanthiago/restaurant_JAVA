package Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private String cliente;
    private List<Item> itens;

    public Pedido(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido nº ").append(numero).append("\n");
        sb.append("Cliente: ").append(cliente).append("\n");
        sb.append("Itens:\n");
        for (Item item : itens) {
            sb.append("  - ").append(item.toString()).append("\n");
        }
        sb.append("Total: R$ ").append(String.format("%.2f", calcularTotal())).append("\n");
        sb.append("-------------------------------");
        return sb.toString();
    }
}