package br.com.mind5.stats.statsOwnerStore.ownerStore.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotSetterZerofy;

final class VisiSowotEnforceZerofy extends ActionVisitorTemplateEnforce<SowotInfo> {
	
	public VisiSowotEnforceZerofy(DeciTreeOption<SowotInfo> option) {
		super(option);
	}

	
	
	@Override protected SowotInfo enforceHook(SowotInfo recordInfo) {
		InfoSetter<SowotInfo> attrSetter = new SowotSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
