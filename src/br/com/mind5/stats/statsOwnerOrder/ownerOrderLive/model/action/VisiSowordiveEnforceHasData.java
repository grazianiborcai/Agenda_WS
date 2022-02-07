package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveSetterHasData;

final class VisiSowordiveEnforceHasData extends ActionVisitorTemplateEnforce<SowordiveInfo> {
	
	public VisiSowordiveEnforceHasData(DeciTreeOption<SowordiveInfo> option) {
		super(option);
	}

	
	
	@Override protected SowordiveInfo enforceHook(SowordiveInfo recordInfo) {
		InfoSetter<SowordiveInfo> attrSetter = new SowordiveSetterHasData();
		return attrSetter.setAttr(recordInfo);
	}
}
