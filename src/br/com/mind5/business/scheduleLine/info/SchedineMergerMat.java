package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerMat extends InfoMergerTemplate<SchedineInfo, MatInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, MatInfo> getVisitorHook() {
		return new SchedineVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
