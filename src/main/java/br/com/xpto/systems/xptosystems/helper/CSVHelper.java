package br.com.xpto.systems.xptosystems.helper;

import br.com.xpto.systems.xptosystems.model.Cidades;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERS = {"ibge_id", "uf", "capital", "lon", "lat", "no_accents", "alternative_names", "microregion", "mesoregion"};

    public static boolean hasCSVFormat(MultipartFile file) {

        return TYPE.equals(file.getContentType());
    }

    public static List<Cidades> csvToCidades(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<Cidades> listaCidades = new ArrayList<Cidades>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Cidades cidades = new Cidades(
                        Integer.parseInt(csvRecord.get("ibge_id")),
                        csvRecord.get("uf"),
                        Boolean.parseBoolean(csvRecord.get("capital")),
                        Double.parseDouble(csvRecord.get("lon")),
                        Double.parseDouble(csvRecord.get("lat")),
                        csvRecord.get("no_accents"),
                        csvRecord.get("alternative_names"),
                        csvRecord.get("microregion"),
                        csvRecord.get("mesoregion")
                );

                listaCidades.add(cidades);
            }

            return listaCidades;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
