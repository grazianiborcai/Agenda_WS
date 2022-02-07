package br.com.mind5.stats.statsOwnerUser.ownerUserLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.info.SowusiveSetterHasData;

final class VisiSowusiveEnforceHasData extends ActionVisitorTemplateEnforce<SowusiveInfo> {
	
	public VisiSowusiveEnforceHasData(DeciTreeOption<SowusiveInfo> option) {
		super(option);
	}

	
	
	@Override protected SowusiveInfo enforceHook(SowusiveInfo recordInfo) {
		InfoSetter<SowusiveInfo> attrSetter = new SowusiveSetterHasData();
		return attrSetter.setAttr(recordInfo);
	}
}
