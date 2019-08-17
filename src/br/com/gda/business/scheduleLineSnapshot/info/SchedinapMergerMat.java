package br.com.gda.business.scheduleLineSnapshot.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedinapMergerMat extends InfoMergerTemplate<SchedinapInfo, MatInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, MatInfo> getVisitorHook() {
		return new SchedinapVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
