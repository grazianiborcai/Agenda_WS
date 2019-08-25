package br.com.gda.business.orderSnapshot.info;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdnapMergerCusarch extends InfoMergerTemplate<OrdnapInfo, CusarchInfo> {

	@Override protected InfoMergerVisitor<OrdnapInfo, CusarchInfo> getVisitorHook() {
		return new OrdnapVisiMergeCusarch();
	}
	
	
	
	@Override protected InfoUniquifier<OrdnapInfo> getUniquifierHook() {
		return new OrdnapUniquifier();
	}
}
