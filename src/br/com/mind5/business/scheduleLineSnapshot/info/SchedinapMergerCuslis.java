package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedinapMergerCuslis extends InfoMergerTemplate_<SchedinapInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor_<SchedinapInfo, CuslisInfo> getVisitorHook() {
		return new SchedinapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
