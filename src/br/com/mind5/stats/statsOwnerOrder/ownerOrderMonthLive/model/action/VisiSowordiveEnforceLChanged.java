package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveSetterLChanged;

final class VisiSowordiveEnforceLChanged extends ActionVisitorTemplateEnforce<SowordiveInfo> {
	
	public VisiSowordiveEnforceLChanged(DeciTreeOption<SowordiveInfo> option) {
		super(option);
	}

	
	
	@Override protected SowordiveInfo enforceHook(SowordiveInfo recordInfo) {
		InfoSetter<SowordiveInfo> attrSetter = new SowordiveSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
