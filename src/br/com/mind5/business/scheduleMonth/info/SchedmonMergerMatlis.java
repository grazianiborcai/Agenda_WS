package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedmonMergerMatlis extends InfoMergerTemplate<SchedmonInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<SchedmonInfo, MatlisInfo> getVisitorHook() {
		return new SchedmonVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
