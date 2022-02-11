package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveSetterHasData;

final class VisiSowordiveEnforceHasData extends ActionVisitorTemplateEnforce<SowaliveInfo> {
	
	public VisiSowordiveEnforceHasData(DeciTreeOption<SowaliveInfo> option) {
		super(option);
	}

	
	
	@Override protected SowaliveInfo enforceHook(SowaliveInfo recordInfo) {
		InfoSetter<SowaliveInfo> attrSetter = new SowaliveSetterHasData();
		return attrSetter.setAttr(recordInfo);
	}
}
