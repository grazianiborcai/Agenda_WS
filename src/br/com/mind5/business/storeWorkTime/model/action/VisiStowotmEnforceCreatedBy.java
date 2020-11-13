package br.com.mind5.business.storeWorkTime.model.action;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStowotmEnforceCreatedBy extends ActionVisitorTemplateEnforce<StowotmInfo> {
	
	public VisiStowotmEnforceCreatedBy(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StowotmInfo enforceHook(StowotmInfo recordInfo) {
		InfoSetter<StowotmInfo> attrSetter = new StowotmSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
