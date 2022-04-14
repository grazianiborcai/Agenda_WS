package br.com.mind5.business.storeLunchTime.model.action;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StuntmInfo> {
	
	public StuntmVisiEnforceLChanged(DeciTreeOption<StuntmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StuntmInfo enforceHook(StuntmInfo recordInfo) {
		InfoSetter<StuntmInfo> attrSetter = new StuntmSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
