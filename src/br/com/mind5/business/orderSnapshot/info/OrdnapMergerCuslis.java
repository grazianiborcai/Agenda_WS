package br.com.mind5.business.orderSnapshot.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdnapMergerCuslis extends InfoMergerTemplate<OrdnapInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor<OrdnapInfo, CuslisInfo> getVisitorHook() {
		return new OrdnapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdnapInfo> getUniquifierHook() {
		return new OrdnapUniquifier();
	}
}
