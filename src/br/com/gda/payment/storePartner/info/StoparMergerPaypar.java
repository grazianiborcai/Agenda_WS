package br.com.gda.payment.storePartner.info;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StoparMergerPaypar extends InfoMergerTemplate<StoparInfo, PayparInfo> {

	@Override protected InfoMergerVisitorV2<StoparInfo, PayparInfo> getVisitorHook() {
		return new StoparVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
