package se.frog.metafrog.files;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileIdentifierTest {

    @Test
    public void canIdentifyFlacFile() throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of("flacfile"));
        assertEquals(FileTypes.FLAC, FileIdentifier.identifyFileType(bytes));
    }

    @Test
    public void canIdentifyOpusFile() throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of("opusfile"));

        assertEquals(FileTypes.OPUS, FileIdentifier.identifyFileType(bytes));
    }

    @Test
    public void returnUnknownForTextFile() throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of("textfile"));

        assertEquals(FileTypes.UNKNOWN, FileIdentifier.identifyFileType(bytes));
    }

}
