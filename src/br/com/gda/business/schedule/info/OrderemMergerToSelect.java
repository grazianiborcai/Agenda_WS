package br.com.gda.business.schedule.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerToSelect extends InfoMergerTemplate<ScheduInfo, ScheduInfo> {

	@Override protected InfoMergerVisitor<ScheduInfo, ScheduInfo> getVisitorHook() {
		return new OrderemVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<ScheduInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
