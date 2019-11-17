package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplateMergerTimezone extends InfoMergerTemplate<EmplateInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor<EmplateInfo, TimezoneInfo> getVisitorHook() {
		return new EmplateVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<EmplateInfo> getUniquifierHook() {
		return new EmplateUniquifier();
	}
}
