package br.com.xpto.systems.xptosystems.service;


import br.com.xpto.systems.xptosystems.model.Cidades;

import java.util.List;

public interface CidadesService {

    List<Cidades> findAll();

    Cidades findByIbgeId(Integer ibgeId);

    Cidades saveCity(Cidades city);

    List<Cidades> findCapitais();

    void deleteCity(Integer ibgeId);
}
