package br.com.mind5.payment.storePartnerList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

final class StoplisMergerStoparch extends InfoMergerTemplate<StoplisInfo, StoparchInfo> {

	@Override protected InfoMergerVisitor<StoplisInfo, StoparchInfo> getVisitorHook() {
		return new StoplisVisiMergeStoparch();
	}
	
	
	
	@Override protected InfoUniquifier<StoplisInfo> getUniquifierHook() {
		return new StoplisUniquifier();
	}
}
