package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrSetterLChanged;

final class VisiStoronagrEnforceLChanged extends ActionVisitorTemplateEnforce<StoronagrInfo> {
	
	public VisiStoronagrEnforceLChanged(DeciTreeOption<StoronagrInfo> option) {
		super(option);
	}

	
	
	@Override protected StoronagrInfo enforceHook(StoronagrInfo recordInfo) {
		InfoSetter<StoronagrInfo> attrSetter = new StoronagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
