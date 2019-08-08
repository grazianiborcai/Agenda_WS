package br.com.gda.business.customerSearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CusarchMergerToSelect extends InfoMergerTemplate<CusarchInfo, CusarchInfo> {

	@Override protected InfoMergerVisitor<CusarchInfo, CusarchInfo> getVisitorHook() {
		return new CusarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusarchInfo> getUniquifierHook() {
		return new CusarchUniquifier();
	}
}
