package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedinapMergerMatsnap extends InfoMergerTemplate_<SchedinapInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor_<SchedinapInfo, MatsnapInfo> getVisitorHook() {
		return new SchedinapVisiMergeMatsnap();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
