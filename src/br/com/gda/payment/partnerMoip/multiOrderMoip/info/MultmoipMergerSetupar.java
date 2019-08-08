package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class MultmoipMergerSetupar extends InfoMergerTemplate<MultmoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<MultmoipInfo, SetuparInfo> getVisitorHook() {
		return new MultmoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
