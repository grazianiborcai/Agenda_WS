package br.com.mind5.business.materialText.info;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MatextCopyMat extends InfoCopierOneToManyTemplate<MatextInfo, MatInfo> {
	
	public MatextCopyMat() {
		super();
	}
	
	
	
	@Override protected List<MatextInfo> makeCopyHook(MatInfo source) {
		return source.matextes;
	}
}
