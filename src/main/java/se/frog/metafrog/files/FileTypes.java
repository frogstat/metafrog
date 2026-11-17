package se.frog.metafrog.files;

import java.nio.charset.StandardCharsets;

public enum FileTypes {
    MP3("MP3", "ID3".getBytes(StandardCharsets.UTF_8)),
    FLAC("FLAC", "fLaC".getBytes(StandardCharsets.UTF_8)),
    OGG("OGG", "OggS".getBytes(StandardCharsets.UTF_8)),
    WAV("WAV", "RIFF".getBytes(StandardCharsets.UTF_8)),
    UNKNOWN("Unknown", new byte[]{});

    private final String name;
    private final byte[] signature;

    FileTypes(String name, byte[] signature) {
        this.name = name;
        this.signature = signature;
    }

    public String getName() {
        return name;
    }

    public byte[] getSignature() {
        return signature.clone();
    }
}