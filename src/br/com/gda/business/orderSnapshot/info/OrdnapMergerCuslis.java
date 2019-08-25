package br.com.gda.business.orderSnapshot.info;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdnapMergerCuslis extends InfoMergerTemplate<OrdnapInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor<OrdnapInfo, CuslisInfo> getVisitorHook() {
		return new OrdnapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdnapInfo> getUniquifierHook() {
		return new OrdnapUniquifier();
	}
}
