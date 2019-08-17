package br.com.gda.business.scheduleLineSnapshot.info;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedinapMergerCuslis extends InfoMergerTemplate<SchedinapInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, CuslisInfo> getVisitorHook() {
		return new SchedinapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
