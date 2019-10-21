package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedinapMergerCuslis extends InfoMergerTemplate<SchedinapInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, CuslisInfo> getVisitorHook() {
		return new SchedinapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
