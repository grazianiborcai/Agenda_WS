package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class PhonapMergerCuslis extends InfoMergerTemplate_<PhonapInfo, CuslisInfo>{

	@Override protected InfoMergerVisitor_<PhonapInfo, CuslisInfo> getVisitorHook() {
		return new PhonapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
