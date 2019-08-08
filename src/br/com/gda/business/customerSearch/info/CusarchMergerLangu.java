package br.com.gda.business.customerSearch.info;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CusarchMergerLangu extends InfoMergerTemplate<CusarchInfo, LanguInfo> {

	@Override protected InfoMergerVisitor<CusarchInfo, LanguInfo> getVisitorHook() {
		return new CusarchVisiMergeLangu();
	}
	
	
	
	@Override protected InfoUniquifier<CusarchInfo> getUniquifierHook() {
		return new CusarchUniquifier();
	}
}
