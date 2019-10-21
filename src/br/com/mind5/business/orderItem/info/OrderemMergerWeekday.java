package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderemMergerWeekday extends InfoMergerTemplate<OrderemInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, WeekdayInfo> getVisitorHook() {
		return new OrderemVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
