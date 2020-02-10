package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class TokemoipMergerSetupar extends InfoMergerTemplate_<TokemoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor_<TokemoipInfo, SetuparInfo> getVisitorHook() {
		return new TokemoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<TokemoipInfo> getUniquifierHook() {
		return new TokemoipUniquifier();
	}
}
