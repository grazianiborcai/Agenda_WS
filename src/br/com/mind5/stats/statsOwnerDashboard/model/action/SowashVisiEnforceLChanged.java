package br.com.mind5.stats.statsOwnerDashboard.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashSetterLChanged;

public final class SowashVisiEnforceLChanged extends ActionVisitorTemplateEnforce<SowashInfo> {
	
	public SowashVisiEnforceLChanged(DeciTreeOption<SowashInfo> option) {
		super(option);
	}

	
	
	@Override protected SowashInfo enforceHook(SowashInfo recordInfo) {
		InfoSetter<SowashInfo> attrSetter = new SowashSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
