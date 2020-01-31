package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplateMergerTimezone extends InfoMergerTemplate_<EmplateInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor_<EmplateInfo, TimezoneInfo> getVisitorHook() {
		return new EmplateVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<EmplateInfo> getUniquifierHook() {
		return new EmplateUniquifier();
	}
}
