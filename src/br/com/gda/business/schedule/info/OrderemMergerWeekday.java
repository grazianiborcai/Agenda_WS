package br.com.gda.business.schedule.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerWeekday extends InfoMergerTemplate<ScheduInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<ScheduInfo, WeekdayInfo> getVisitorHook() {
		return new OrderemVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<ScheduInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
