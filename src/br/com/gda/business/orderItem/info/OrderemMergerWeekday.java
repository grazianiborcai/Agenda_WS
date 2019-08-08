package br.com.gda.business.orderItem.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerWeekday extends InfoMergerTemplate<OrderemInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, WeekdayInfo> getVisitorHook() {
		return new OrderemVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
