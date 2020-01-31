package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedinapMergerStolis extends InfoMergerTemplate_<SchedinapInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<SchedinapInfo, StolisInfo> getVisitorHook() {
		return new SchedinapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
