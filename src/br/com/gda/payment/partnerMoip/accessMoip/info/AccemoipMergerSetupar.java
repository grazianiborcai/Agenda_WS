package br.com.gda.payment.partnerMoip.accessMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class AccemoipMergerSetupar extends InfoMergerTemplate<AccemoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<AccemoipInfo, SetuparInfo> getVisitorHook() {
		return new AccemoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<AccemoipInfo> getUniquifierHook() {
		return new AccemoipUniquifier();
	}
}
