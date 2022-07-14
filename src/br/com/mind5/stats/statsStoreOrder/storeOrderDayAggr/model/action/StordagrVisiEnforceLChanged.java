package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrSetterLChanged;

public final class StordagrVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StordagrInfo> {
	
	public StordagrVisiEnforceLChanged(DeciTreeOption<StordagrInfo> option) {
		super(option);
	}

	
	
	@Override protected StordagrInfo enforceHook(StordagrInfo recordInfo) {
		InfoSetter<StordagrInfo> attrSetter = new StordagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
