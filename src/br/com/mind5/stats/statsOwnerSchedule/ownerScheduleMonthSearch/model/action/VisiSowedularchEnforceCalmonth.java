package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchhInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchSetterCalmonth;

final class VisiSowedularchEnforceCalmonth extends ActionVisitorTemplateEnforce<SowedularchhInfo> {
	
	public VisiSowedularchEnforceCalmonth(DeciTreeOption<SowedularchhInfo> option) {
		super(option);
	}

	
	
	@Override protected SowedularchhInfo enforceHook(SowedularchhInfo recordInfo) {
		InfoSetter<SowedularchhInfo> attrSetter = new SowedularchSetterCalmonth();
		return attrSetter.setAttr(recordInfo);
	}
}
