package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.info.SoweduliveSetterHasData;

final class VisiSoweduliveEnforceHasData extends ActionVisitorTemplateEnforce<SoweduliveInfo> {
	
	public VisiSoweduliveEnforceHasData(DeciTreeOption<SoweduliveInfo> option) {
		super(option);
	}

	
	
	@Override protected SoweduliveInfo enforceHook(SoweduliveInfo recordInfo) {
		InfoSetter<SoweduliveInfo> attrSetter = new SoweduliveSetterHasData();
		return attrSetter.setAttr(recordInfo);
	}
}
