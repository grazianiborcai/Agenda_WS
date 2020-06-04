package br.com.mind5.business.scheduleMonth.model.action;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonSetterNow;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedmonEnforceNow extends ActionVisitorTemplateEnforceV2<SchedmonInfo> {
	
	public VisiSchedmonEnforceNow(DeciTreeOption<SchedmonInfo> option) {
		super(option);
	}

	
	
	@Override protected SchedmonInfo enforceHook(SchedmonInfo recordInfo) {
		InfoSetter<SchedmonInfo> attrSetter = new SchedmonSetterNow();
		return attrSetter.setAttr(recordInfo);
	}
}
