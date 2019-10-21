package br.com.mind5.payment.partnerMoip.accessMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class AccemoipMergerSetupar extends InfoMergerTemplate<AccemoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<AccemoipInfo, SetuparInfo> getVisitorHook() {
		return new AccemoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<AccemoipInfo> getUniquifierHook() {
		return new AccemoipUniquifier();
	}
}
