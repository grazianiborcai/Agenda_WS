package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CusparMergerToSelect extends InfoMergerTemplate<CusparInfo, CusparInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, CusparInfo> getVisitorHook() {
		return new CusparVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
