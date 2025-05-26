package br.com.alura.VeiculosInfoFipe.service;

import java.util.List;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);

    <T> List<T> obterDadosList(String json, Class<T> classe);
}
