package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveSetterLChanged;

public final class SteddiveVisiEnforceLChanged extends ActionVisitorTemplateEnforce<SteddiveInfo> {
	
	public SteddiveVisiEnforceLChanged(DeciTreeOption<SteddiveInfo> option) {
		super(option);
	}

	
	
	@Override protected SteddiveInfo enforceHook(SteddiveInfo recordInfo) {
		InfoSetter<SteddiveInfo> attrSetter = new SteddiveSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
