package se.frog.metafrog.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;

public class FileIdentifier {

    public static FileTypes identifyFileType(File file) throws IOException {

        int maxLength = Arrays.stream(FileTypes.values())
                .map(FileTypes::getSignature)
                .mapToInt(signature -> signature.length)
                .max()
                .orElse(0);

        try(FileInputStream fis = new FileInputStream(file)) {
            byte[] fileHeader = fis.readNBytes(maxLength);

            for (FileTypes fileType : FileTypes.values()) {
                byte[] signature = fileType.getSignature();

                if (fileMatchesType(signature, fileHeader)) {
                    return fileType;
                }
            }

            return FileTypes.UNKNOWN;
        }
    }

    private static boolean fileMatchesType(byte[] targetMagick, byte[] header){
        if(targetMagick.length > header.length){
            return false;
        }

        for (int i = 0; i < targetMagick.length; i++) {
            if (targetMagick[i] != header[i]) {
                return false;
            }
        }
        return true;
    }


}
