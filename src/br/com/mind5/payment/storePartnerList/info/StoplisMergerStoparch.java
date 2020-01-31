package br.com.mind5.payment.storePartnerList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

final class StoplisMergerStoparch extends InfoMergerTemplate_<StoplisInfo, StoparchInfo> {

	@Override protected InfoMergerVisitor_<StoplisInfo, StoparchInfo> getVisitorHook() {
		return new StoplisVisiMergeStoparch();
	}
	
	
	
	@Override protected InfoUniquifier<StoplisInfo> getUniquifierHook() {
		return new StoplisUniquifier();
	}
}
