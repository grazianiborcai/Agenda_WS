package br.com.gda.business.schedule.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class ScheduMergerMat extends InfoMergerTemplate<ScheduInfo, MatInfo> {

	@Override protected InfoMergerVisitor<ScheduInfo, MatInfo> getVisitorHook() {
		return new ScheduVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<ScheduInfo> getUniquifierHook() {
		return new ScheduUniquifier();
	}
}
