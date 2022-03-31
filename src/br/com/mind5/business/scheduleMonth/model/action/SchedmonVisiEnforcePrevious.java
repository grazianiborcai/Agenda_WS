package br.com.mind5.business.scheduleMonth.model.action;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonSetterPrevious;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedmonVisiEnforcePrevious extends ActionVisitorTemplateEnforce<SchedmonInfo> {
	
	public SchedmonVisiEnforcePrevious(DeciTreeOption<SchedmonInfo> option) {
		super(option);
	}

	
	
	@Override protected SchedmonInfo enforceHook(SchedmonInfo recordInfo) {
		InfoSetter<SchedmonInfo> attrSetter = new SchedmonSetterPrevious();
		return attrSetter.setAttr(recordInfo);
	}
}
