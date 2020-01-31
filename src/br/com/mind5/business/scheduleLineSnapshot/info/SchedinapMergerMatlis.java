package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedinapMergerMatlis extends InfoMergerTemplate_<SchedinapInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor_<SchedinapInfo, MatlisInfo> getVisitorHook() {
		return new SchedinapVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
