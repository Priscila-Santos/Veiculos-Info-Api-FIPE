package br.com.alura.VeiculosInfoFipe.view;

import br.com.alura.VeiculosInfoFipe.model.Dados;
import br.com.alura.VeiculosInfoFipe.model.Veiculo;
import br.com.alura.VeiculosInfoFipe.util.VeiculoFiltroUtil;

import java.util.List;
import java.util.Scanner;

public class MenuView {

    public String selecionarTipoVeiculo(Scanner scanner) {
        System.out.println("""
                ****** OPÇÕES DE VEÍCULOS *****
                1 - CARRO
                2 - MOTO
                3 - CAMINHÃO
                """);

        System.out.print("Digite o número da opção desejada: ");
        String opcao = scanner.nextLine();
        return switch (opcao) {
            case "1" -> "carros";
            case "2" -> "motos";
            case "3" -> "caminhoes";
            default -> {
                System.out.println("Opção inválida.");
                yield null;
            }
        };
    }

    public String selecionarMarca(List<Dados> marcas, Scanner scanner) {
        System.out.println("\n***** MARCAS DISPONÍVEIS *****");
        for (int i = 0; i < marcas.size(); i++) {
            System.out.println((i + 1) + " - " + marcas.get(i).nome());
        }

        System.out.print("Digite o número da marca desejada: ");
        try {
            int escolha = Integer.parseInt(scanner.nextLine());
            return marcas.get(escolha - 1).codigo();
        } catch (Exception e) {
            System.out.println("Entrada inválida.");
            return null;
        }
    }

    public String selecionarModelo(List<Dados> modelos, Scanner scanner) {
        System.out.println("\n***** MODELOS DISPONÍVEIS *****");
        for (int i = 0; i < modelos.size(); i++) {
            System.out.println((i + 1) + " - " + modelos.get(i).nome());
        }

        System.out.print("Digite o número do modelo desejado: ");
        try {
            int escolha = Integer.parseInt(scanner.nextLine());
            return modelos.get(escolha - 1).codigo();
        } catch (Exception e) {
            System.out.println("Entrada inválida.");
            return null;
        }
    }

    public void exibirMenuFiltros(Scanner scanner, List<Veiculo> veiculos) {
        System.out.println("""
                \nComo deseja visualizar os veículos?
                1 - Ordenar por ANO
                2 - Ordenar por PREÇO
                """);

        System.out.print("Digite o número da opção desejada: ");
        String opcao = scanner.nextLine();
        switch (opcao) {
            case "1" -> VeiculoFiltroUtil.exibirPorAno(veiculos, scanner);
            case "2" -> VeiculoFiltroUtil.exibirPorPreco(veiculos);
            default -> System.out.println("Opção inválida.");
        }
    }
}
