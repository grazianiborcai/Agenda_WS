package br.com.mind5.stats.statsOwnerUser.userAccountLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.info.SowusiveSetterLChanged;

final class VisiSowusiveEnforceLChanged extends ActionVisitorTemplateEnforce<SowusiveInfo> {
	
	public VisiSowusiveEnforceLChanged(DeciTreeOption<SowusiveInfo> option) {
		super(option);
	}

	
	
	@Override protected SowusiveInfo enforceHook(SowusiveInfo recordInfo) {
		InfoSetter<SowusiveInfo> attrSetter = new SowusiveSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
