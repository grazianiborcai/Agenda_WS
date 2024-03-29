package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveSetterLChanged;

public final class StedmoniveVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StedmoniveInfo> {
	
	public StedmoniveVisiEnforceLChanged(DeciTreeOption<StedmoniveInfo> option) {
		super(option);
	}

	
	
	@Override protected StedmoniveInfo enforceHook(StedmoniveInfo recordInfo) {
		InfoSetter<StedmoniveInfo> attrSetter = new StedmoniveSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
