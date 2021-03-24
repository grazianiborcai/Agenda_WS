package br.com.mind5.file.fileWrite.info;


import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImageSys.info.FimgysInfo;
import br.com.mind5.info.InfoCopier;

public final class FriteCopier {
	public static List<FriteInfo> copyFromFimgys(List<FimgysInfo> sources) {
		InfoCopier<FriteInfo, FimgysInfo> copier = new FriteCopyFimgys();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<FriteInfo> copyFromFimg(List<FimgInfo> sources) {
		InfoCopier<FriteInfo, FimgInfo> copier = new FriteCopyFimg();
		return copier.makeCopy(sources);
	}
}
