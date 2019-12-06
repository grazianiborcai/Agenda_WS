package br.com.mind5.business.materialText.info;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.info.InfoCopierOneToMany;

public final class MatextCopier {
	public static List<MatextInfo> copyFromMat(MatInfo source) {
		InfoCopierOneToMany<MatextInfo, MatInfo> copier = new MatextCopyMat();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatextInfo> copyFromMat(List<MatInfo> sources) {
		InfoCopierOneToMany<MatextInfo, MatInfo> copier = new MatextCopyMat();
		return copier.makeCopy(sources);
	}
	
	
	
	public static MatextInfo copyFromMatKey(MatInfo source) {
		InfoCopier<MatextInfo, MatInfo> copier = new MatextCopyMatKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatextInfo> copyFromMatKey(List<MatInfo> sources) {
		InfoCopier<MatextInfo, MatInfo> copier = new MatextCopyMatKey();
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
