package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class PhonapMergerStolis extends InfoMergerTemplate<PhonapInfo, StolisInfo>{

	@Override protected InfoMergerVisitor<PhonapInfo, StolisInfo> getVisitorHook() {
		return new PhonapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
