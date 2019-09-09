package br.com.gda.business.scheduleWeek.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedeekMergerMat extends InfoMergerTemplate<SchedeekInfo, MatInfo> {

	@Override protected InfoMergerVisitor<SchedeekInfo, MatInfo> getVisitorHook() {
		return new SchedeekVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
