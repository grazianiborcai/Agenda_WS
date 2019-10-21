package br.com.mind5.payment.storePartnerList.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoplisMergerPaypar extends InfoMergerTemplate<StoplisInfo, PayparInfo> {

	@Override protected InfoMergerVisitor<StoplisInfo, PayparInfo> getVisitorHook() {
		return new StoplisVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<StoplisInfo> getUniquifierHook() {
		return new StoplisUniquifier();
	}
}
