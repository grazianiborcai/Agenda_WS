package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedinapMergerMatlis extends InfoMergerTemplate<SchedinapInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, MatlisInfo> getVisitorHook() {
		return new SchedinapVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
