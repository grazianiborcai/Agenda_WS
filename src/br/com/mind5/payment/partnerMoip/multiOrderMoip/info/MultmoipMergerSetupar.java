package br.com.mind5.payment.partnerMoip.multiOrderMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class MultmoipMergerSetupar extends InfoMergerTemplate_<MultmoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor_<MultmoipInfo, SetuparInfo> getVisitorHook() {
		return new MultmoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
