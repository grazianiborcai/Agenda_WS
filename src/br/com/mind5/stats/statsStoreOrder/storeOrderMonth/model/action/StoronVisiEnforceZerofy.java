package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronSetterZerofy;

public final class StoronVisiEnforceZerofy extends ActionVisitorTemplateEnforce<StoronInfo> {
	
	public StoronVisiEnforceZerofy(DeciTreeOption<StoronInfo> option) {
		super(option);
	}

	
	
	@Override protected StoronInfo enforceHook(StoronInfo recordInfo) {
		InfoSetter<StoronInfo> attrSetter = new StoronSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
