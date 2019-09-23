package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class PhonapMergerCuslis extends InfoMergerTemplate<PhonapInfo, CuslisInfo>{

	@Override protected InfoMergerVisitor<PhonapInfo, CuslisInfo> getVisitorHook() {
		return new PhonapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
