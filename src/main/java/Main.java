import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.EncryptionMethod;

public class Main {

    public static void main(String[] args) throws ZipException {

        /* https://github.com/srikanth-lingala/zip4j */

        /*
        <dependency>
            <groupId>net.lingala.zip4j</groupId>
            <artifactId>zip4j</artifactId>
            <version>2.6.1</version>
        </dependency>
         */

        /* Zip com senha */

        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);
        zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
        zipParameters.setFileComment("Ricardo Gayer");
        ZipFile zipFile = new ZipFile("arquivo.zip", "minhasenha".toCharArray());
        zipFile.addFile("arquivo.html", zipParameters);

        /* Unzip com senha */
        new ZipFile("arquivo.zip","minhasenha".toCharArray()).extractAll(".");

    }

}
