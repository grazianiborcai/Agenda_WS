package br.com.gda.business.scheduleMonth.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedmonMergerMat extends InfoMergerTemplate<SchedmonInfo, MatInfo> {

	@Override protected InfoMergerVisitor<SchedmonInfo, MatInfo> getVisitorHook() {
		return new SchedmonVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
