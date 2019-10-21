package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedinapMergerMatsnap extends InfoMergerTemplate<SchedinapInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, MatsnapInfo> getVisitorHook() {
		return new SchedinapVisiMergeMatsnap();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
