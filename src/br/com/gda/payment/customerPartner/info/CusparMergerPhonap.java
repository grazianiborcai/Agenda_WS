package br.com.gda.payment.customerPartner.info;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CusparMergerPhonap extends InfoMergerTemplate<CusparInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, PhonapInfo> getVisitorHook() {
		return new CusparVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
