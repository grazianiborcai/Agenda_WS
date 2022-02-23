package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveSetterLChanged;

final class VisiStoroniveEnforceLChanged extends ActionVisitorTemplateEnforce<StoroniveInfo> {
	
	public VisiStoroniveEnforceLChanged(DeciTreeOption<StoroniveInfo> option) {
		super(option);
	}

	
	
	@Override protected StoroniveInfo enforceHook(StoroniveInfo recordInfo) {
		InfoSetter<StoroniveInfo> attrSetter = new StoroniveSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
