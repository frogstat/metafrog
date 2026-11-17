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
        File file = Paths.get("testfiles/test.flac").toFile();
        assertEquals(FileTypes.FLAC, FileIdentifier.identifyFileType(file));
    }

    @Test
    public void canIdentifyOpusFile() throws IOException {
        File file = Paths.get("testfiles/test.opus").toFile();

        assertEquals(FileTypes.OGG, FileIdentifier.identifyFileType(file));
    }

    @Test
    public void canIdentifyOggFile() throws IOException {
        File file = Paths.get("testfiles/test.ogg").toFile();

        assertEquals(FileTypes.OGG, FileIdentifier.identifyFileType(file));
    }

    @Test
    public void canIdentifyWavFile() throws IOException {
        File file = Paths.get("testfiles/test.wav").toFile();

        assertEquals(FileTypes.WAV, FileIdentifier.identifyFileType(file));
    }

    @Test
    public void canIdentifyMP3File() throws IOException {
        File file = Paths.get("testfiles/test.mp3").toFile();

        assertEquals(FileTypes.MP3, FileIdentifier.identifyFileType(file));
    }

    @Test
    public void returnUnknownForTextFile() throws IOException {
        File file = Paths.get("testfiles/test.txt").toFile();

        assertEquals(FileTypes.UNKNOWN, FileIdentifier.identifyFileType(file));
    }

}
