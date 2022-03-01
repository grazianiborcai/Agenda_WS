package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrSetterLChanged;

public final class SowedulagrVisiEnforceLChanged extends ActionVisitorTemplateEnforce<SowedulagrInfo> {
	
	public SowedulagrVisiEnforceLChanged(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}

	
	
	@Override protected SowedulagrInfo enforceHook(SowedulagrInfo recordInfo) {
		InfoSetter<SowedulagrInfo> attrSetter = new SowedulagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
