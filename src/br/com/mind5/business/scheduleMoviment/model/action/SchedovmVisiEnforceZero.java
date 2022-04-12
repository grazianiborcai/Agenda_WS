package br.com.mind5.business.scheduleMoviment.model.action;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.business.scheduleMoviment.info.SchedovmSetterZero;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedovmVisiEnforceZero extends ActionVisitorTemplateEnforce<SchedovmInfo> {	

	public SchedovmVisiEnforceZero(DeciTreeOption<SchedovmInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected SchedovmInfo enforceHook(SchedovmInfo recordInfo) {
		InfoSetter<SchedovmInfo> setter = new SchedovmSetterZero();
		return setter.setAttr(recordInfo);
	}
}
