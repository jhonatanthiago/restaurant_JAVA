package Restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante {
    private static List<Pedido> pedidos = new ArrayList<>();
    private static int contadorPedidos = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n=== Restaurante BomSabor ===");
            System.out.println("1. Registrar Pedido");
            System.out.println("2. Remover Pedido");
            System.out.println("3. Listar Pedidos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            String linha = sc.nextLine();
            try {
                opcao = Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    registrarPedido(sc);
                    break;
                case 2:
                    removerPedido(sc);
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Digite 1 a 4.");
            }
        } while (opcao != 4);

        sc.close();
    }

    private static void registrarPedido(Scanner sc) {
        System.out.print("Nome do cliente: ");
        String cliente = sc.nextLine().trim();
        if (cliente.isEmpty()) cliente = "Cliente sem nome";

        Pedido pedido = new Pedido(contadorPedidos++, cliente);

        while (true) {
            System.out.print("Nome do item (ou 'fim' para encerrar): ");
            String nomeItem = sc.nextLine().trim();
            if (nomeItem.equalsIgnoreCase("fim")) break;
            if (nomeItem.isEmpty()) {
                System.out.println("Nome do item não pode ser vazio.");
                continue;
            }

            double preco = lerDoubleValido(sc, "Preço do item (ex: 12.50): ");
            pedido.adicionarItem(new Item(nomeItem, preco));
        }

        if (pedido.calcularTotal() == 0 && pedido.toString().contains("Itens:") && pedido.toString().split("\n").length <= 3) {
            System.out.println("Pedido vazio. Nenhum item adicionado. Pedido não registrado.");
            return;
        }

        pedidos.add(pedido);
        System.out.println("\nPedido registrado com sucesso!");
        System.out.println(pedido);
    }

    private static void removerPedido(Scanner sc) {
        System.out.print("Número do pedido a remover: ");
        String linha = sc.nextLine();
        int numero;
        try {
            numero = Integer.parseInt(linha);
        } catch (NumberFormatException e) {
            System.out.println("Número inválido.");
            return;
        }

        Pedido pedidoRemover = null;
        for (Pedido p : pedidos) {
            if (p.getNumero() == numero) {
                pedidoRemover = p;
                break;
            }
        }

        if (pedidoRemover != null) {
            pedidos.remove(pedidoRemover);
            System.out.println("Pedido nº " + numero + " removido com sucesso!");
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    private static void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        System.out.println("\n=== Lista de Pedidos ===");
        pedidos.sort((p1, p2) -> Integer.compare(p1.getNumero(), p2.getNumero()));
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }

    private static double lerDoubleValido(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = sc.nextLine().replace(",", ".").trim();
            try {
                double v = Double.parseDouble(linha);
                if (v < 0) {
                    System.out.println("Preço inválido! Digite um valor >= 0.");
                } else {
                    return v;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Use apenas números (ex: 10.50).");
            }
        }
    }
}