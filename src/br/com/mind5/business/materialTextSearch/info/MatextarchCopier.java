package br.com.mind5.business.materialTextSearch.info;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
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
	
	
	
	public static MatextarchInfo copyFromMatextsnap(MatextsnapInfo source) {
		InfoCopier<MatextarchInfo, MatextsnapInfo> copier = new MatextarchCopyMatextsnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatextarchInfo> copyFromMatextsnap(List<MatextsnapInfo> sources) {
		InfoCopier<MatextarchInfo, MatextsnapInfo> copier = new MatextarchCopyMatextsnap();
		return copier.makeCopy(sources);
	}	
}
