package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddSetterZerofy;

public final class SteddVisiEnforceZerofy extends ActionVisitorTemplateEnforce<SteddInfo> {
	
	public SteddVisiEnforceZerofy(DeciTreeOption<SteddInfo> option) {
		super(option);
	}

	
	
	@Override protected SteddInfo enforceHook(SteddInfo recordInfo) {
		InfoSetter<SteddInfo> attrSetter = new SteddSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
