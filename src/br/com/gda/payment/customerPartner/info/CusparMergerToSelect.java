package br.com.gda.payment.customerPartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CusparMergerToSelect extends InfoMergerTemplate<CusparInfo, CusparInfo> {

	@Override protected InfoMergerVisitorV2<CusparInfo, CusparInfo> getVisitorHook() {
		return new CusparVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
