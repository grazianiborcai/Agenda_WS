package br.com.mind5.file.fileImageSearch.info;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.info.InfoCopier;

public final class FimarchCopier {	
	public static FimarchInfo copyFromFimgUser(FimgInfo source) {
		InfoCopier<FimarchInfo, FimgInfo> copier = new FimarchCopyFimgUser();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimarchInfo> copyFromFimgUser(List<FimgInfo> sources) {
		InfoCopier<FimarchInfo, FimgInfo> copier = new FimarchCopyFimgUser();
		return copier.makeCopy(sources);
	}	
}
