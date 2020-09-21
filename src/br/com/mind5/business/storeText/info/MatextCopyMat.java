package br.com.mind5.business.storeText.info;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MatextCopyMat extends InfoCopierOneToManyTemplate<StorextInfo, MatInfo> {
	
	public MatextCopyMat() {
		super();
	}
	
	
	
	@Override protected List<StorextInfo> makeCopyHook(MatInfo source) {
		return source.matextes;
	}
}
