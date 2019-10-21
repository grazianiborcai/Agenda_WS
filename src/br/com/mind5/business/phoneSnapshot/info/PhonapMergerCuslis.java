package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class PhonapMergerCuslis extends InfoMergerTemplate<PhonapInfo, CuslisInfo>{

	@Override protected InfoMergerVisitor<PhonapInfo, CuslisInfo> getVisitorHook() {
		return new PhonapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
