package com.kwyjibo.file.copier.util;

import java.io.IOException;
import java.nio.file.Path;

public interface Copier {
	
	void copyFile() throws IOException;
	
	boolean createAlbumArtistDirectory(Path targetDir) throws IOException;
	
	boolean createMasterDirectory(Path masterDir) throws IOException;
}
