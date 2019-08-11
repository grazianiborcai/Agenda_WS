package br.com.gda.business.schedule.info;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerMatore extends InfoMergerTemplate<ScheduInfo, MatoreInfo> {

	@Override protected InfoMergerVisitor<ScheduInfo, MatoreInfo> getVisitorHook() {
		return new OrderemVisiMergeMatore();
	}
	
	
	
	@Override protected InfoUniquifier<ScheduInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
