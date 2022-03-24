package br.com.mind5.business.storeWorkTime.model.action;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StowotmInfo> {
	
	public StowotmVisiEnforceLChanged(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StowotmInfo enforceHook(StowotmInfo recordInfo) {
		InfoSetter<StowotmInfo> attrSetter = new StowotmSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
