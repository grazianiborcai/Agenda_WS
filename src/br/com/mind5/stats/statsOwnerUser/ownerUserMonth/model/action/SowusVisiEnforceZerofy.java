package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusSetterZerofy;

public final class SowusVisiEnforceZerofy extends ActionVisitorTemplateEnforce<SowusInfo> {
	
	public SowusVisiEnforceZerofy(DeciTreeOption<SowusInfo> option) {
		super(option);
	}

	
	
	@Override protected SowusInfo enforceHook(SowusInfo recordInfo) {
		InfoSetter<SowusInfo> attrSetter = new SowusSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
