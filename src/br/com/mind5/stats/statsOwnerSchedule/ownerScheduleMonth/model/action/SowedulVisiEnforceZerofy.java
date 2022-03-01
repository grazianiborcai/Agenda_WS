package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulSetterZerofy;

public final class SowedulVisiEnforceZerofy extends ActionVisitorTemplateEnforce<SowedulInfo> {
	
	public SowedulVisiEnforceZerofy(DeciTreeOption<SowedulInfo> option) {
		super(option);
	}

	
	
	@Override protected SowedulInfo enforceHook(SowedulInfo recordInfo) {
		InfoSetter<SowedulInfo> attrSetter = new SowedulSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
