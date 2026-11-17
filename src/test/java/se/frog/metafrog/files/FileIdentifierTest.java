package se.frog.metafrog.files;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileIdentifierTest {

    @Test
    public void canIdentifyFlacFile() throws IOException {
        File file = Paths.get("flacfile").toFile();
        assertEquals(FileTypes.FLAC, FileIdentifier.identifyFileType(file));
    }

    @Test
    public void canIdentifyOpusFile() throws IOException {
        File file = Paths.get("opusfile").toFile();

        assertEquals(FileTypes.OPUS, FileIdentifier.identifyFileType(file));
    }

    @Test
    public void returnUnknownForTextFile() throws IOException {
        File file = Paths.get("textfile").toFile();

        assertEquals(FileTypes.UNKNOWN, FileIdentifier.identifyFileType(file));
    }

}
