package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrSetterLChanged;

public final class SowordagrVisiEnforceLChanged extends ActionVisitorTemplateEnforce<SowordagrInfo> {
	
	public SowordagrVisiEnforceLChanged(DeciTreeOption<SowordagrInfo> option) {
		super(option);
	}

	
	
	@Override protected SowordagrInfo enforceHook(SowordagrInfo recordInfo) {
		InfoSetter<SowordagrInfo> attrSetter = new SowordagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
