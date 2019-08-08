package br.com.gda.payment.partnerMoip.tokenMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class TokemoipMergerSetupar extends InfoMergerTemplate<TokemoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<TokemoipInfo, SetuparInfo> getVisitorHook() {
		return new TokemoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<TokemoipInfo> getUniquifierHook() {
		return new TokemoipUniquifier();
	}
}
