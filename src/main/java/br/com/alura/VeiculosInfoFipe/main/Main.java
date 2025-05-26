//package br.com.alura.VeiculosInfoFipe.main;
//
//import br.com.alura.VeiculosInfoFipe.model.Dados;
//import br.com.alura.VeiculosInfoFipe.model.Modelos;
//import br.com.alura.VeiculosInfoFipe.model.Veiculo;
//import br.com.alura.VeiculosInfoFipe.service.ConsumoApi;
//import br.com.alura.VeiculosInfoFipe.service.ConverteDados;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//
//public class Main {
//    private Scanner leitura = new Scanner(System.in);
//    private final String URl_BASE = "https://parallelum.com.br/fipe/api/v1/";
//    private ConsumoApi consumoApi = new ConsumoApi();
//    private ConverteDados conversor = new ConverteDados();
//
//    public void exibirMenu() {
//        var menu =
//                """
//                ****** OPÇÕES DE VEÍCULOS *****
//                1 - CARRO
//                2 - MOTO
//                3 - CAMINHÃO
//
//                Digite a opção desejada:
//                """;
//        System.out.println(menu);
//        var opcao = leitura.nextLine();
//        String endereco = "";
//
//        if (opcao.equals("1")) {
//            endereco = URl_BASE + "carros/marcas";
//        } else if (opcao.equals("2")) {
//            endereco = URl_BASE + "motos/marcas";
//        } else if (opcao.equals("3")) {
//            endereco = URl_BASE + "caminhoes/marcas";
//        } else {
//            System.out.println("opção invalida!");
//        }
//
//        var json = consumoApi.obterDados(endereco);
//        System.out.println(json);
//        var marcas = conversor.obterDadosList(json, Dados.class);
//        marcas.stream()
//                .sorted(Comparator.comparing(Dados::codigo))
//                .forEach(System.out::println);
//
//        System.out.println("Informe o nome da marca para consulta");
//        var codigoMarca = leitura.nextLine();
//
//        endereco = endereco + "/" + codigoMarca + "/modelos";
//        json = consumoApi.obterDados(endereco);
//        var modeloLista = conversor.obterDados(json, Modelos.class);
//
//        System.out.println("\n Modelos dessa marca");
//        modeloLista.modelos().stream()
//                .sorted(Comparator.comparing(Dados::codigo))
//                .forEach(System.out::println);
//
//        System.out.println("\nDigite o nome da modelo para consulta");
//        String nomeVeiculo = leitura.nextLine();
//
//        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
//                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
//                .collect(Collectors.toList());
//
//        System.out.println("\nModelos Filtrados");
//        modelosFiltrados.forEach(System.out::println);
//
//        System.out.println("Digite por favor o código do modelo para buscar os valores de avaliação: ");
//        var codigoModelo = leitura.nextLine();
//
//        endereco = endereco + "/" + codigoModelo + "/anos";
//        json = consumoApi.obterDados(endereco);
//        List<Dados> anos = conversor.obterDadosList(json, Dados.class);
//        List<Veiculo> veiculos = new ArrayList<>();
//
//        for (int i = 0; i < anos.size(); i++) {
//            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
//            json = consumoApi.obterDados(enderecoAnos);
//            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
//            veiculos.add(veiculo);
//        }
//
//        System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");
//        veiculos.forEach(System.out::println);
//
//    }
//}
//
