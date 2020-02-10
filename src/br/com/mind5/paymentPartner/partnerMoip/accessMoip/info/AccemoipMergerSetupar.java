package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class AccemoipMergerSetupar extends InfoMergerTemplate_<AccemoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor_<AccemoipInfo, SetuparInfo> getVisitorHook() {
		return new AccemoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<AccemoipInfo> getUniquifierHook() {
		return new AccemoipUniquifier();
	}
}
