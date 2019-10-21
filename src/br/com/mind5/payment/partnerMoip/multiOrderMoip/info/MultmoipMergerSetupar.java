package br.com.mind5.payment.partnerMoip.multiOrderMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class MultmoipMergerSetupar extends InfoMergerTemplate<MultmoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<MultmoipInfo, SetuparInfo> getVisitorHook() {
		return new MultmoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
