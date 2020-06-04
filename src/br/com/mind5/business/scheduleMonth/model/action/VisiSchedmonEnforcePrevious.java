package br.com.mind5.business.scheduleMonth.model.action;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonSetterPrevious;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedmonEnforcePrevious extends ActionVisitorTemplateEnforceV2<SchedmonInfo> {
	
	public VisiSchedmonEnforcePrevious(DeciTreeOption<SchedmonInfo> option) {
		super(option);
	}

	
	
	@Override protected SchedmonInfo enforceHook(SchedmonInfo recordInfo) {
		InfoSetter<SchedmonInfo> attrSetter = new SchedmonSetterPrevious();
		return attrSetter.setAttr(recordInfo);
	}
}
