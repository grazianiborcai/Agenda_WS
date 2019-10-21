package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedinapMergerMat extends InfoMergerTemplate<SchedinapInfo, MatInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, MatInfo> getVisitorHook() {
		return new SchedinapVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
