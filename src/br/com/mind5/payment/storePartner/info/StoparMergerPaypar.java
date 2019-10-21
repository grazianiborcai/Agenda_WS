package br.com.mind5.payment.storePartner.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoparMergerPaypar extends InfoMergerTemplate<StoparInfo, PayparInfo> {

	@Override protected InfoMergerVisitor<StoparInfo, PayparInfo> getVisitorHook() {
		return new StoparVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
