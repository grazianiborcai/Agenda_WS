package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordSetterZerofy;

final class VisiStordEnforceZerofy extends ActionVisitorTemplateEnforce<StordInfo> {
	
	public VisiStordEnforceZerofy(DeciTreeOption<StordInfo> option) {
		super(option);
	}

	
	
	@Override protected StordInfo enforceHook(StordInfo recordInfo) {
		InfoSetter<StordInfo> attrSetter = new StordSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
