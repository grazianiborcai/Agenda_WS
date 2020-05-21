package br.com.mind5.business.scheduleMoviment.model.action;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.business.scheduleMoviment.info.SchedovmSetterZero;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedovmEnforceZero extends ActionVisitorTemplateEnforceV2<SchedovmInfo> {	

	public VisiSchedovmEnforceZero(DeciTreeOption<SchedovmInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected SchedovmInfo enforceHook(SchedovmInfo recordInfo) {
		InfoSetter<SchedovmInfo> setter = new SchedovmSetterZero();
		return setter.setAttr(recordInfo);
	}
}
