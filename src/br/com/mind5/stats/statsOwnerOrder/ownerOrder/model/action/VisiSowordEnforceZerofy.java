package br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordSetterZerofy;

final class VisiSowordEnforceZerofy extends ActionVisitorTemplateEnforce<SowordInfo> {
	
	public VisiSowordEnforceZerofy(DeciTreeOption<SowordInfo> option) {
		super(option);
	}

	
	
	@Override protected SowordInfo enforceHook(SowordInfo recordInfo) {
		InfoSetter<SowordInfo> attrSetter = new SowordSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
