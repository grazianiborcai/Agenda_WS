package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdemrapMergerWeekday extends InfoMergerTemplate<OrdemrapInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, WeekdayInfo> getVisitorHook() {
		return new OrdemrapVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
