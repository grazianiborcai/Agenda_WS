package br.com.mind5.business.storeProspectCounter.model.action;

import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.business.storeProspectCounter.info.StoprosouSetterItemCounter;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosouVisiEnforceItemCounter extends ActionVisitorTemplateEnforce<StoprosouInfo> {
	
	public StoprosouVisiEnforceItemCounter(DeciTreeOption<StoprosouInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoprosouInfo enforceHook(StoprosouInfo recordInfo) {
		InfoSetter<StoprosouInfo> setter = new StoprosouSetterItemCounter();
		return setter.setAttr(recordInfo);
	}
}
