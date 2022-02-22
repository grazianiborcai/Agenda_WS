package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrSetterLChanged;

final class VisiStedmonagrEnforceLChanged extends ActionVisitorTemplateEnforce<StedmonagrInfo> {
	
	public VisiStedmonagrEnforceLChanged(DeciTreeOption<StedmonagrInfo> option) {
		super(option);
	}

	
	
	@Override protected StedmonagrInfo enforceHook(StedmonagrInfo recordInfo) {
		InfoSetter<StedmonagrInfo> attrSetter = new StedmonagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
