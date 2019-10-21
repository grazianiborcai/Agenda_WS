package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedinapMergerStolis extends InfoMergerTemplate<SchedinapInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, StolisInfo> getVisitorHook() {
		return new SchedinapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
