package br.com.mind5.business.storeLunchTime.model.action;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmSetterDel;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmVisiEnforceDel extends ActionVisitorTemplateEnforce<StuntmInfo> {
	
	public StuntmVisiEnforceDel(DeciTreeOption<StuntmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StuntmInfo enforceHook(StuntmInfo recordInfo) {
		InfoSetter<StuntmInfo> attrSetter = new StuntmSetterDel();
		return attrSetter.setAttr(recordInfo);
	}
}
