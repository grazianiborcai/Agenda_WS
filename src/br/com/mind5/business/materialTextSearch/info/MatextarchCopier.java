package br.com.mind5.business.materialTextSearch.info;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoCopier;

public final class MatextarchCopier {

	public static MatextarchInfo copyFromMatext(MatextInfo source) {
		InfoCopier<MatextarchInfo, MatextInfo> copier = new MatextarchCopyMatext();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatextarchInfo> copyFromMatext(List<MatextInfo> sources) {
		InfoCopier<MatextarchInfo, MatextInfo> copier = new MatextarchCopyMatext();
		return copier.makeCopy(sources);
	}
}
