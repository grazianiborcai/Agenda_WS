package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdemrapMergerWeekday extends InfoMergerTemplate_<OrdemrapInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor_<OrdemrapInfo, WeekdayInfo> getVisitorHook() {
		return new OrdemrapVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
