package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrSetterLChanged;

public final class StedmonagrVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StedmonagrInfo> {
	
	public StedmonagrVisiEnforceLChanged(DeciTreeOption<StedmonagrInfo> option) {
		super(option);
	}

	
	
	@Override protected StedmonagrInfo enforceHook(StedmonagrInfo recordInfo) {
		InfoSetter<StedmonagrInfo> attrSetter = new StedmonagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
