package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonSetterZerofy;

public final class StedmonVisiEnforceZerofy extends ActionVisitorTemplateEnforce<StedmonInfo> {
	
	public StedmonVisiEnforceZerofy(DeciTreeOption<StedmonInfo> option) {
		super(option);
	}

	
	
	@Override protected StedmonInfo enforceHook(StedmonInfo recordInfo) {
		InfoSetter<StedmonInfo> attrSetter = new StedmonSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
