package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedmonMergerMatlis extends InfoMergerTemplate_<SchedmonInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor_<SchedmonInfo, MatlisInfo> getVisitorHook() {
		return new SchedmonVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
