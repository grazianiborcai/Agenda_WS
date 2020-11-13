package br.com.mind5.business.storeProspect.model.action;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.info.StoprosSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoprosEnforceCreatedOn extends ActionVisitorTemplateEnforce<StoprosInfo> {
	
	public VisiStoprosEnforceCreatedOn(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoprosInfo enforceHook(StoprosInfo recordInfo) {
		InfoSetter<StoprosInfo> attrSetter = new StoprosSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
