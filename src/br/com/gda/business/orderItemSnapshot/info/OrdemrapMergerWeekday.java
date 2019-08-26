package br.com.gda.business.orderItemSnapshot.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdemrapMergerWeekday extends InfoMergerTemplate<OrdemrapInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, WeekdayInfo> getVisitorHook() {
		return new OrdemrapVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
