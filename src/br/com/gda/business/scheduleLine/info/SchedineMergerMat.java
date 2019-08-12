package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedineMergerMat extends InfoMergerTemplate<SchedineInfo, MatInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, MatInfo> getVisitorHook() {
		return new SchedineVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
