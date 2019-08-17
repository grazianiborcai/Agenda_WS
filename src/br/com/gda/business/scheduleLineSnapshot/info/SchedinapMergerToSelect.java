package br.com.gda.business.scheduleLineSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedinapMergerToSelect extends InfoMergerTemplate<SchedinapInfo, SchedinapInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, SchedinapInfo> getVisitorHook() {
		return new SchedinapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
