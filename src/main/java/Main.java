import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.EncryptionMethod;

import java.io.File;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws ZipException, InterruptedException {

        /* https://github.com/srikanth-lingala/zip4j */

        /*
        <dependency>
            <groupId>net.lingala.zip4j</groupId>
            <artifactId>zip4j</artifactId>
            <version>2.6.1</version>
        </dependency>
         */

        /* Zip com senha */

        UUID uuid = UUID.randomUUID();

        System.out.println("UUID = " + uuid.toString());

        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);
        zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
        zipParameters.setFileComment("Ricardo Gayer");
        ZipFile zipFile = new ZipFile("arquivo.zip", uuid.toString().toCharArray());
        zipFile.addFile("arquivo.html", zipParameters);

        Thread.sleep(5000);

        File file = new File("arquivo.html");

        if (file.delete()) {
            System.out.println("Arquivo excluído com sucesso");
        } else {
            System.out.println("Erro durante a exclusão do arquivo");
        }

        Thread.sleep(5000);

        /* Unzip com senha */
        new ZipFile("arquivo.zip",uuid.toString().toCharArray()).extractAll(".");

    }

}
