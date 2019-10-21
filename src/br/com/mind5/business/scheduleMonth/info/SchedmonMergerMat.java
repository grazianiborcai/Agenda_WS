package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedmonMergerMat extends InfoMergerTemplate<SchedmonInfo, MatInfo> {

	@Override protected InfoMergerVisitor<SchedmonInfo, MatInfo> getVisitorHook() {
		return new SchedmonVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
