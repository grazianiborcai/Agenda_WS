package br.com.mind5.business.storeLunchTime.model.action;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<StuntmInfo> {
	
	public StuntmVisiEnforceCreatedBy(DeciTreeOption<StuntmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StuntmInfo enforceHook(StuntmInfo recordInfo) {
		InfoSetter<StuntmInfo> attrSetter = new StuntmSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
