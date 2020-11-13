package br.com.mind5.business.storeProspect.model.action;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.info.StoprosSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoprosEnforceLChanged extends ActionVisitorTemplateEnforce<StoprosInfo> {
	
	public VisiStoprosEnforceLChanged(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoprosInfo enforceHook(StoprosInfo recordInfo) {
		InfoSetter<StoprosInfo> attrSetter = new StoprosSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
