package se.frog.metafrog.files;

import java.util.Map;

public class FileIdentifier {

    private static Map<FileTypes, byte[]> fileMagicks = Map.of(
            FileTypes.FLAC, "fLaC".getBytes(),
            FileTypes.OPUS, "OggS".getBytes(),
            FileTypes.MP3, "ID3".getBytes()
    );


    public static FileTypes identifyFileType(byte[] bytes) {

        for (Map.Entry<FileTypes, byte[]> entry : fileMagicks.entrySet()) {
            if (fileMatchesType(entry.getValue(), bytes)) {
                return entry.getKey();
            }
        }

        return FileTypes.UNKNOWN;
    }

    private static boolean fileMatchesType(byte[] targetMagick, byte[] file){
        if(targetMagick.length > file.length){
            return false;
        }

        for (int i = 0; i < targetMagick.length; i++) {
            if (targetMagick[i] != file[i]) {
                return false;
            }
        }

        return true;
    }


}
