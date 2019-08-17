package br.com.gda.business.scheduleLineSnapshot.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedinapMergerStolis extends InfoMergerTemplate<SchedinapInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, StolisInfo> getVisitorHook() {
		return new SchedinapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
