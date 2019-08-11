package br.com.gda.business.schedule.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerMat extends InfoMergerTemplate<ScheduInfo, MatInfo> {

	@Override protected InfoMergerVisitor<ScheduInfo, MatInfo> getVisitorHook() {
		return new OrderemVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<ScheduInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
