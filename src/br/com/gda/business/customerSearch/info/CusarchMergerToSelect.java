package br.com.gda.business.customerSearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CusarchMergerToSelect extends InfoMergerTemplate<CusarchInfo, CusarchInfo> {

	@Override protected InfoMergerVisitorV2<CusarchInfo, CusarchInfo> getVisitorHook() {
		return new CusarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusarchInfo> getUniquifierHook() {
		return new CusarchUniquifier();
	}
}
