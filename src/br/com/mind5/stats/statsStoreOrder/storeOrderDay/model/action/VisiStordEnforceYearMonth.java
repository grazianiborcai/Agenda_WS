package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordSetterYearMonth;

final class VisiStordEnforceYearMonth extends ActionVisitorTemplateEnforce<StordInfo> {
	
	public VisiStordEnforceYearMonth(DeciTreeOption<StordInfo> option) {
		super(option);
	}

	
	
	@Override protected StordInfo enforceHook(StordInfo recordInfo) {
		InfoSetter<StordInfo> attrSetter = new StordSetterYearMonth();
		return attrSetter.setAttr(recordInfo);
	}
}
