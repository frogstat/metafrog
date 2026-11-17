package se.frog.metafrog.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class FileIdentifier {

    private static Map<FileTypes, byte[]> fileMagicks = Map.of(
            FileTypes.FLAC, "fLaC".getBytes(),
            FileTypes.OPUS, "OggS".getBytes(),
            FileTypes.MP3, "ID3".getBytes()
    );


    public static FileTypes identifyFileType(File file) {

        int maxLength = fileMagicks.values().stream()
                .mapToInt(fileMagick -> fileMagick.length)
                .max()
                .orElse(0);

        try(FileInputStream fis = new FileInputStream(file)) {
            byte[] fileHeader = fis.readNBytes(maxLength);

            for (Map.Entry<FileTypes, byte[]> entry : fileMagicks.entrySet()) {
                if (fileMatchesType(entry.getValue(), fileHeader)) {
                    return entry.getKey();
                }
            }
            return FileTypes.UNKNOWN;
        } catch (IOException e) {
            throw new RuntimeException(e);
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
