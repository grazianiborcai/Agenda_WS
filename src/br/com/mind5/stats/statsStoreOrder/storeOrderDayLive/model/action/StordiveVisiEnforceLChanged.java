package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveSetterLChanged;

public final class StordiveVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StordiveInfo> {
	
	public StordiveVisiEnforceLChanged(DeciTreeOption<StordiveInfo> option) {
		super(option);
	}

	
	
	@Override protected StordiveInfo enforceHook(StordiveInfo recordInfo) {
		InfoSetter<StordiveInfo> attrSetter = new StordiveSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
