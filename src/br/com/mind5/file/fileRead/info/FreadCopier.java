package br.com.mind5.file.fileRead.info;


import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.info.InfoCopier;

public final class FreadCopier {
	public static FreadInfo copyFromFimg(FimgInfo source) {
		InfoCopier<FreadInfo, FimgInfo> copier = new FreadCopyFimg();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FreadInfo> copyFromFimg(List<FimgInfo> sources) {
		InfoCopier<FreadInfo, FimgInfo> copier = new FreadCopyFimg();
		return copier.makeCopy(sources);
	}
}
