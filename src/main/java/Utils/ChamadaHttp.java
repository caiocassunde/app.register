package Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ChamadaHttp {
    private static final String HTTP = "http://localhost:8084/api/teste";
    public static String chamadaHttp() throws IOException {
        Http http = new Http();
        String retornoJson = http.chamaUrl(HTTP);

        /*Código de Exemplo para gravação de arquivo
        FileWriter arquivo = new FileWriter(new File("D:\\Arquivo.json"));
        arquivo.write(retornoJson);
        arquivo.close();*/

        return retornoJson;
    }
}