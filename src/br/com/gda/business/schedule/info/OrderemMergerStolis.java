package br.com.gda.business.schedule.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerStolis extends InfoMergerTemplate<ScheduInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<ScheduInfo, StolisInfo> getVisitorHook() {
		return new OrderemVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<ScheduInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
