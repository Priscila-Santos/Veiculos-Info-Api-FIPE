package br.com.alura.VeiculosInfoFipe.util;


import br.com.alura.VeiculosInfoFipe.model.Veiculo;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class VeiculoFiltroUtil {

    public static void exibirPorAno(List<Veiculo> veiculos, Scanner scanner) {
        System.out.println("Ver do mais ANTIGO ou NOVO? (A/N):");
        String ordem = scanner.nextLine();

        Comparator<Veiculo> comp = Comparator.comparing(Veiculo::anoModelo);
        if (ordem.equalsIgnoreCase("N")) comp = comp.reversed();

        List<Veiculo> ordenados = veiculos.stream().sorted(comp).toList();
        paginar(ordenados, scanner);
    }

    public static void exibirPorPreco(List<Veiculo> veiculos) {
        veiculos.stream()
                .sorted(Comparator.comparing(v -> Double.parseDouble(v.valor().replaceAll("[^\\d,]", "").replace(",", "."))))
                .forEach(v -> System.out.printf("%s | ano: %d | valor: %s | combustível: %s%n",
                        v.modelo(), v.anoModelo(), v.valor(), v.combustivel()));
    }

    private static void paginar(List<Veiculo> lista, Scanner scanner) {
        int page = 0, perPage = 3;

        while (page * perPage < lista.size()) {
            int start = page * perPage;
            int end = Math.min(start + perPage, lista.size());

            for (int i = start; i < end; i++) {
                Veiculo v = lista.get(i);
                System.out.printf("%d - %s ano: %d valor: %s combustível: %s%n",
                        i + 1, v.modelo(), v.anoModelo(), v.valor(), v.combustivel());
            }

            if (end < lista.size()) {
                System.out.println("\nENTER para próxima página ou 'sair':");
                String cmd = scanner.nextLine();
                if (cmd.equalsIgnoreCase("sair")) break;
                page++;
            } else break;
        }
    }
}

