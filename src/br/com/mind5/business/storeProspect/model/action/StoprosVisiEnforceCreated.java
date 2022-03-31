package br.com.mind5.business.storeProspect.model.action;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.info.StoprosSetterCreated;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosVisiEnforceCreated extends ActionVisitorTemplateEnforce<StoprosInfo> {
	
	public StoprosVisiEnforceCreated(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoprosInfo enforceHook(StoprosInfo recordInfo) {
		InfoSetter<StoprosInfo> attrSetter = new StoprosSetterCreated();
		return attrSetter.setAttr(recordInfo);
	}
}
