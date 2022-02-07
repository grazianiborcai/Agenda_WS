package br.com.mind5.stats.statsOwnerUser.ownerUser.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusSetterZerofy;

final class VisiSowusEnforceZerofy extends ActionVisitorTemplateEnforce<SowusInfo> {
	
	public VisiSowusEnforceZerofy(DeciTreeOption<SowusInfo> option) {
		super(option);
	}

	
	
	@Override protected SowusInfo enforceHook(SowusInfo recordInfo) {
		InfoSetter<SowusInfo> attrSetter = new SowusSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
