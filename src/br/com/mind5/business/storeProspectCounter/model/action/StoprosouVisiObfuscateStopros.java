package br.com.mind5.business.storeProspectCounter.model.action;

import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.business.storeProspectCounter.info.StoprosouSetterStopros;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosouVisiObfuscateStopros extends ActionVisitorTemplateEnforce<StoprosouInfo> {
	
	public StoprosouVisiObfuscateStopros(DeciTreeOption<StoprosouInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoprosouInfo enforceHook(StoprosouInfo recordInfo) {
		InfoSetter<StoprosouInfo> setter = new StoprosouSetterStopros();
		return setter.setAttr(recordInfo);
	}
}
