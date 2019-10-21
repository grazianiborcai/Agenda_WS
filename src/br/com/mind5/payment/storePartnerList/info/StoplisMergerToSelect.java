package br.com.mind5.payment.storePartnerList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoplisMergerToSelect extends InfoMergerTemplate<StoplisInfo, StoplisInfo> {

	@Override protected InfoMergerVisitor<StoplisInfo, StoplisInfo> getVisitorHook() {
		return new StoplisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoplisInfo> getUniquifierHook() {
		return new StoplisUniquifier();
	}
}
