package br.com.gda.payment.customerPartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CusparMergerToSelect extends InfoMergerTemplate<CusparInfo, CusparInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, CusparInfo> getVisitorHook() {
		return new CusparVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
