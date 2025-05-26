package br.com.alura.VeiculosInfoFipe.controller;


import br.com.alura.VeiculosInfoFipe.model.Dados;
import br.com.alura.VeiculosInfoFipe.model.Modelos;
import br.com.alura.VeiculosInfoFipe.model.Veiculo;
import br.com.alura.VeiculosInfoFipe.service.ConsumoApi;
import br.com.alura.VeiculosInfoFipe.service.ConverteDados;
import br.com.alura.VeiculosInfoFipe.view.MenuView;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VeiculoController {
    private final Scanner leitura = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados conversor = new ConverteDados();
    private final MenuView view = new MenuView();

    public void iniciarConsulta() {
        String tipoVeiculo = view.selecionarTipoVeiculo(leitura);
        if (tipoVeiculo == null) return;

        List<Dados> marcas = obterMarcas(tipoVeiculo);
        String codigoMarca = view.selecionarMarca(marcas, leitura);
        if (codigoMarca == null) return;

        List<Dados> modelosFiltrados = buscarModelosFiltrados(tipoVeiculo, codigoMarca);
        String codigoModelo = view.selecionarModelo(modelosFiltrados, leitura);
        if (codigoModelo == null) return;

        List<Veiculo> veiculos = obterVeiculos(tipoVeiculo, codigoMarca, codigoModelo);
        view.exibirMenuFiltros(leitura, veiculos);
    }

    private List<Dados> obterMarcas(String tipo) {
        String url = URL_BASE + tipo + "/marcas";
        var json = consumoApi.obterDados(url);
        return conversor.obterDadosList(json, Dados.class);
    }

    private List<Dados> buscarModelosFiltrados(String tipo, String codigoMarca) {
        String url = URL_BASE + tipo + "/marcas/" + codigoMarca + "/modelos";
        var json = consumoApi.obterDados(url);
        Modelos modelos = conversor.obterDados(json, Modelos.class);

        System.out.println("\nDigite parte do nome do modelo:");
        String filtro = leitura.nextLine().toLowerCase();
        return modelos.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(filtro))
                .toList();
    }

    private List<Veiculo> obterVeiculos(String tipo, String codigoMarca, String codigoModelo) {
        String url = URL_BASE + tipo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos";
        var json = consumoApi.obterDados(url);
        List<Dados> anos = conversor.obterDadosList(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (Dados ano : anos) {
            String anoUrl = URL_BASE + tipo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/" + ano.codigo();
            String jsonVeiculo = consumoApi.obterDados(anoUrl);
            veiculos.add(conversor.obterDados(jsonVeiculo, Veiculo.class));
        }

        return veiculos;
    }
}

