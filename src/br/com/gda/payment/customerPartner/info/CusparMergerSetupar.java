package br.com.gda.payment.customerPartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class CusparMergerSetupar extends InfoMergerTemplate<CusparInfo, SetuparInfo> {

	@Override protected InfoMergerVisitorV2<CusparInfo, SetuparInfo> getVisitorHook() {
		return new CusparVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
