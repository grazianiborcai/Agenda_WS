package br.com.gda.business.scheduleLineSnapshot.info;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedinapMergerMatsnap extends InfoMergerTemplate<SchedinapInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, MatsnapInfo> getVisitorHook() {
		return new SchedinapVisiMergeMatsnap();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
