package br.com.mind5.stats.statsOwnerSale.ownerSale.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalSetterZerofy;

final class VisiSowalEnforceZerofy extends ActionVisitorTemplateEnforce<SowalInfo> {
	
	public VisiSowalEnforceZerofy(DeciTreeOption<SowalInfo> option) {
		super(option);
	}

	
	
	@Override protected SowalInfo enforceHook(SowalInfo recordInfo) {
		InfoSetter<SowalInfo> attrSetter = new SowalSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
