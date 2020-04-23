package br.com.mind5.business.storeLeaveDate.model.action;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolateEnforceCreatedBy extends ActionVisitorTemplateEnforceV2<StolateInfo> {
	
	public VisiStolateEnforceCreatedBy(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StolateInfo enforceHook(StolateInfo recordInfo) {
		InfoSetter<StolateInfo> attrSetter = new StolateSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
