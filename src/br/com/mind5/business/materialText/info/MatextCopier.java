package br.com.mind5.business.materialText.info;

import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoCopier;

public final class MatextCopier {
	public static MatextInfo copyToDelete(MatextInfo source) {
		InfoCopier<MatextInfo, MatextInfo> copier = new MatextCopyToDelete();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatextInfo> copyToDelete(List<MatextInfo> sources) {
		InfoCopier<MatextInfo, MatextInfo> copier = new MatextCopyToDelete();
		return copier.makeCopy(sources);
	}
	
	
	
	public static MatextInfo copyFromMatextsnap(MatextsnapInfo source) {
		InfoCopier<MatextInfo, MatextsnapInfo> copier = new MatextCopyMatextsnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatextInfo> copyFromMatextsnap(List<MatextsnapInfo> sources) {
		InfoCopier<MatextInfo, MatextsnapInfo> copier = new MatextCopyMatextsnap();
		return copier.makeCopy(sources);
	}
}
