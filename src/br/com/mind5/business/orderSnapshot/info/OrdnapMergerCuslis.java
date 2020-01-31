package br.com.mind5.business.orderSnapshot.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdnapMergerCuslis extends InfoMergerTemplate_<OrdnapInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor_<OrdnapInfo, CuslisInfo> getVisitorHook() {
		return new OrdnapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdnapInfo> getUniquifierHook() {
		return new OrdnapUniquifier();
	}
}
