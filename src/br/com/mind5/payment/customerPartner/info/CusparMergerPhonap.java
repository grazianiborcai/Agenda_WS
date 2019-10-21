package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CusparMergerPhonap extends InfoMergerTemplate<CusparInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, PhonapInfo> getVisitorHook() {
		return new CusparVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
