package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedinapMergerToSelect extends InfoMergerTemplate_<SchedinapInfo, SchedinapInfo> {

	@Override protected InfoMergerVisitor_<SchedinapInfo, SchedinapInfo> getVisitorHook() {
		return new SchedinapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
