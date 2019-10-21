package br.com.mind5.business.customerSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CusarchMergerToSelect extends InfoMergerTemplate<CusarchInfo, CusarchInfo> {

	@Override protected InfoMergerVisitor<CusarchInfo, CusarchInfo> getVisitorHook() {
		return new CusarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusarchInfo> getUniquifierHook() {
		return new CusarchUniquifier();
	}
}
