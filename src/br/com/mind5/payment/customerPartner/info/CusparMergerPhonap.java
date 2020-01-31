package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusparMergerPhonap extends InfoMergerTemplate_<CusparInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor_<CusparInfo, PhonapInfo> getVisitorHook() {
		return new CusparVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
