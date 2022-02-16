package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrSetterHasData;

final class VisiSteddagrEnforceHasData extends ActionVisitorTemplateEnforce<SteddagrInfo> {
	
	public VisiSteddagrEnforceHasData(DeciTreeOption<SteddagrInfo> option) {
		super(option);
	}

	
	
	@Override protected SteddagrInfo enforceHook(SteddagrInfo recordInfo) {
		InfoSetter<SteddagrInfo> attrSetter = new SteddagrSetterHasData();
		return attrSetter.setAttr(recordInfo);
	}
}
