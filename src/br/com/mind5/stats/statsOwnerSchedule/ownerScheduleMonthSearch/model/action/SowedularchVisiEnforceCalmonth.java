package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchSetterCalmonth;

public final class SowedularchVisiEnforceCalmonth extends ActionVisitorTemplateEnforce<SowedularchInfo> {
	
	public SowedularchVisiEnforceCalmonth(DeciTreeOption<SowedularchInfo> option) {
		super(option);
	}

	
	
	@Override protected SowedularchInfo enforceHook(SowedularchInfo recordInfo) {
		InfoSetter<SowedularchInfo> attrSetter = new SowedularchSetterCalmonth();
		return attrSetter.setAttr(recordInfo);
	}
}
