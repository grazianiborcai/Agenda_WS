package br.com.mind5.business.storeText.info;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.info.InfoCopierOneToMany;

public final class MatextCopier {
	public static List<StorextInfo> copyFromMat(MatInfo source) {
		InfoCopierOneToMany<StorextInfo, MatInfo> copier = new MatextCopyMat();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StorextInfo> copyFromMat(List<MatInfo> sources) {
		InfoCopierOneToMany<StorextInfo, MatInfo> copier = new MatextCopyMat();
		return copier.makeCopy(sources);
	}
	
	
	
	public static StorextInfo copyFromMatKey(MatInfo source) {
		InfoCopier<StorextInfo, MatInfo> copier = new MatextCopyMatKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StorextInfo> copyFromMatKey(List<MatInfo> sources) {
		InfoCopier<StorextInfo, MatInfo> copier = new MatextCopyMatKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static StorextInfo copyFromMatextsnap(MatextsnapInfo source) {
		InfoCopier<StorextInfo, MatextsnapInfo> copier = new MatextCopyMatextsnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StorextInfo> copyFromMatextsnap(List<MatextsnapInfo> sources) {
		InfoCopier<StorextInfo, MatextsnapInfo> copier = new MatextCopyMatextsnap();
		return copier.makeCopy(sources);
	}
}
