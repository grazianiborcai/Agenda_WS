package br.com.gda.file.fileWrite.info;


import java.util.List;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.info.InfoCopier;

public final class FriteCopier {
	public static FriteInfo copyFromFimg(FimgInfo source) {
		InfoCopier<FriteInfo, FimgInfo> copier = new FriteCopyFimg();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FriteInfo> copyFromFimg(List<FimgInfo> sources) {
		InfoCopier<FriteInfo, FimgInfo> copier = new FriteCopyFimg();
		return copier.makeCopy(sources);
	}
}
