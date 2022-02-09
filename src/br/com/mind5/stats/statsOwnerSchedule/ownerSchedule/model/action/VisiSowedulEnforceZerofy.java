package br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulSetterZerofy;

final class VisiSowedulEnforceZerofy extends ActionVisitorTemplateEnforce<SowedulInfo> {
	
	public VisiSowedulEnforceZerofy(DeciTreeOption<SowedulInfo> option) {
		super(option);
	}

	
	
	@Override protected SowedulInfo enforceHook(SowedulInfo recordInfo) {
		InfoSetter<SowedulInfo> attrSetter = new SowedulSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
