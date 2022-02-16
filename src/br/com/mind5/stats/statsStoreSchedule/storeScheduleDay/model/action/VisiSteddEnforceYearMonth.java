package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddSetterYearMonth;

final class VisiSteddEnforceYearMonth extends ActionVisitorTemplateEnforce<SteddInfo> {
	
	public VisiSteddEnforceYearMonth(DeciTreeOption<SteddInfo> option) {
		super(option);
	}

	
	
	@Override protected SteddInfo enforceHook(SteddInfo recordInfo) {
		InfoSetter<SteddInfo> attrSetter = new SteddSetterYearMonth();
		return attrSetter.setAttr(recordInfo);
	}
}
