package br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveSetterLChanged;

public final class SowusiveVisiEnforceLChanged extends ActionVisitorTemplateEnforce<SowusiveInfo> {
	
	public SowusiveVisiEnforceLChanged(DeciTreeOption<SowusiveInfo> option) {
		super(option);
	}

	
	
	@Override protected SowusiveInfo enforceHook(SowusiveInfo recordInfo) {
		InfoSetter<SowusiveInfo> attrSetter = new SowusiveSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
