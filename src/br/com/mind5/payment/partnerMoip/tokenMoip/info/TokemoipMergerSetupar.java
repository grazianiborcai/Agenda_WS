package br.com.mind5.payment.partnerMoip.tokenMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class TokemoipMergerSetupar extends InfoMergerTemplate<TokemoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<TokemoipInfo, SetuparInfo> getVisitorHook() {
		return new TokemoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<TokemoipInfo> getUniquifierHook() {
		return new TokemoipUniquifier();
	}
}
