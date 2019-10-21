package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedinapMergerToSelect extends InfoMergerTemplate<SchedinapInfo, SchedinapInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, SchedinapInfo> getVisitorHook() {
		return new SchedinapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
