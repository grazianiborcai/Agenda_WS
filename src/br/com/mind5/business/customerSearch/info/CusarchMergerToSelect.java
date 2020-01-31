package br.com.mind5.business.customerSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusarchMergerToSelect extends InfoMergerTemplate_<CusarchInfo, CusarchInfo> {

	@Override protected InfoMergerVisitor_<CusarchInfo, CusarchInfo> getVisitorHook() {
		return new CusarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusarchInfo> getUniquifierHook() {
		return new CusarchUniquifier();
	}
}
