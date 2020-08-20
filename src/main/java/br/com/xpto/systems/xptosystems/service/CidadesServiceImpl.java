package br.com.xpto.systems.xptosystems.service;

import br.com.xpto.systems.xptosystems.exception.CityNotFoundException;
import br.com.xpto.systems.xptosystems.model.Cidades;
import br.com.xpto.systems.xptosystems.repository.CidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadesServiceImpl implements CidadesService {

    @Autowired
    private CidadesRepository cidadesRepository;

    @Override
    public List<Cidades> findAll() {
        return cidadesRepository.findAll();
    }

    @Override
    public Cidades findByIbgeId(Integer ibgeId) {
        Cidades city = cidadesRepository.findByIbgeId(ibgeId).orElseThrow(
                () -> new CityNotFoundException("Cidade com o código do IBGE [" + ibgeId
                        + "] não encontrado no sistema."));
        return city;
    }

    @Override
    public Cidades saveCity(Cidades cidades) {
        return cidadesRepository.save(cidades);
    }

    @Override
    public List<Cidades> findCapitais() {
        return cidadesRepository.findByCapitalTrue();
    }

    @Override
    public void deleteCity(Integer ibgeId) {

        Cidades city = cidadesRepository.findByIbgeId(ibgeId).orElseThrow(
                () -> new CityNotFoundException("Cidade com o código do IBGE ["
                        + ibgeId + "] não econtrado no sistema."));
        cidadesRepository.delete(city);
    }
}
