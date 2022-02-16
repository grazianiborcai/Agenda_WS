package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveSetterHasData;

final class VisiSteddiveEnforceHasData extends ActionVisitorTemplateEnforce<SteddiveInfo> {
	
	public VisiSteddiveEnforceHasData(DeciTreeOption<SteddiveInfo> option) {
		super(option);
	}

	
	
	@Override protected SteddiveInfo enforceHook(SteddiveInfo recordInfo) {
		InfoSetter<SteddiveInfo> attrSetter = new SteddiveSetterHasData();
		return attrSetter.setAttr(recordInfo);
	}
}
