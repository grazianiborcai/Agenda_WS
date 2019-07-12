package br.com.gda.payment.tokenMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.storePartner.info.StoparInfo;

final class TokemoipMergerStopar extends InfoMergerTemplate<TokemoipInfo, StoparInfo> {

	@Override protected InfoMergerVisitorV2<TokemoipInfo, StoparInfo> getVisitorHook() {
		return new TokemoipVisiMergeStopar();
	}
	
	
	
	@Override protected InfoUniquifier<TokemoipInfo> getUniquifierHook() {
		return new TokemoipUniquifier();
	}
}
