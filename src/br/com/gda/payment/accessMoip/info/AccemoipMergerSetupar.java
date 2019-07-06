package br.com.gda.payment.accessMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class AccemoipMergerSetupar extends InfoMergerTemplate<AccemoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitorV2<AccemoipInfo, SetuparInfo> getVisitorHook() {
		return new AccemoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<AccemoipInfo> getUniquifierHook() {
		return new AccemoipUniquifier();
	}
}
