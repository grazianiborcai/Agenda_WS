package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrSetterLChanged;

final class VisiStedmonagrEnforceLChanged extends ActionVisitorTemplateEnforce<SowedulagrInfo> {
	
	public VisiStedmonagrEnforceLChanged(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}

	
	
	@Override protected SowedulagrInfo enforceHook(SowedulagrInfo recordInfo) {
		InfoSetter<SowedulagrInfo> attrSetter = new SowedulagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
