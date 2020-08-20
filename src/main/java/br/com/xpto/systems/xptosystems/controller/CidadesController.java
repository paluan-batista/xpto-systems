package br.com.xpto.systems.xptosystems.controller;

import br.com.xpto.systems.xptosystems.model.Cidades;
import br.com.xpto.systems.xptosystems.service.CidadesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/cities")
@Api(value="API Cidades  - XptoSystems")
public class CidadesController {

    @Autowired
    private CidadesService service;


    @ApiOperation(value = "Retorna uma lista com todas as cidades cadastradas.")
    @GetMapping(value = "/all")
    public List<Cidades> listaCidades() {
        return service.findAll();
    }


    @ApiOperation(value="Retorna todas as cidades que também são capitais.")
    @GetMapping(value = "/capitais")
    public List<Cidades> listaCapitais() {
        return service.findCapitais();
    }

    @ApiOperation(value="Retorna uma cidade através do IBGE_ID.")
    @GetMapping(value = "/{ibgeId}")
    public Cidades findByIbgeId(@PathVariable(name = "ibgeId") Integer ibgeId) {
        return service.findByIbgeId(ibgeId);
    }

    @ApiOperation(value="Adiciona uma nova cidade.")
    @PostMapping(value = "/save")
    public ResponseEntity<Cidades> salvaCidade(@RequestBody Cidades cidades) {
        service.saveCity(cidades);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("api/cities/{ibgeId}")
                        .buildAndExpand(cidades.getIbgeId()).toUri())
                .build();
    }

    @ApiOperation(value="Deleta uma cidade através do IBGE_ID.")
    @DeleteMapping(value = "/delete/{ibgeId}")
    public ResponseEntity<Void> deleteCity(@PathVariable(name = "ibgeId") Integer ibgeId) {
        service.deleteCity(ibgeId);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value="Atualiza uma ou mais cidades. Nesse caso, todos os campos devem ser informados," +
            "mesmo se a alteração for em apenas 1 campo.")
    @PutMapping(value = "/update")
    public Cidades atualizaCidade(@RequestBody @Valid Cidades cidade) {
        return service.saveCity(cidade);
    }
}
