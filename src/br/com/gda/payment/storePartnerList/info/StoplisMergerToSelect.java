package br.com.gda.payment.storePartnerList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoplisMergerToSelect extends InfoMergerTemplate<StoplisInfo, StoplisInfo> {

	@Override protected InfoMergerVisitor<StoplisInfo, StoplisInfo> getVisitorHook() {
		return new StoplisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoplisInfo> getUniquifierHook() {
		return new StoplisUniquifier();
	}
}
