package br.com.xpto.systems.xptosystems.service;

import br.com.xpto.systems.xptosystems.helper.CSVHelper;
import br.com.xpto.systems.xptosystems.model.Cidades;
import br.com.xpto.systems.xptosystems.repository.ArchivesRepository;
import br.com.xpto.systems.xptosystems.repository.CidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    ArchivesRepository archivesRepository;

    public void save(MultipartFile file) {
        try {
            List<Cidades> cidades = CSVHelper.csvToCidades(file.getInputStream());
            archivesRepository.saveAll(cidades);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
