package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonSetterZerofy;

final class VisiStedmonEnforceZerofy extends ActionVisitorTemplateEnforce<StedmonInfo> {
	
	public VisiStedmonEnforceZerofy(DeciTreeOption<StedmonInfo> option) {
		super(option);
	}

	
	
	@Override protected StedmonInfo enforceHook(StedmonInfo recordInfo) {
		InfoSetter<StedmonInfo> attrSetter = new StedmonSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
