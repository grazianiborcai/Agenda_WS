package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusparMergerToSelect extends InfoMergerTemplate_<CusparInfo, CusparInfo> {

	@Override protected InfoMergerVisitor_<CusparInfo, CusparInfo> getVisitorHook() {
		return new CusparVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
