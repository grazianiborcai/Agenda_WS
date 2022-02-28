package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveSetterLChanged;

final class VisiSoweduliveEnforceLChanged extends ActionVisitorTemplateEnforce<SoweduliveInfo> {
	
	public VisiSoweduliveEnforceLChanged(DeciTreeOption<SoweduliveInfo> option) {
		super(option);
	}

	
	
	@Override protected SoweduliveInfo enforceHook(SoweduliveInfo recordInfo) {
		InfoSetter<SoweduliveInfo> attrSetter = new SoweduliveSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
