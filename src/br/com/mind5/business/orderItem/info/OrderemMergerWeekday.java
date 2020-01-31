package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemMergerWeekday extends InfoMergerTemplate_<OrderemInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor_<OrderemInfo, WeekdayInfo> getVisitorHook() {
		return new OrderemVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
