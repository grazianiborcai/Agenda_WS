package br.com.mind5.business.storeLeaveDate.model.action;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateSetterValidTo;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolateEnforceValidTo extends ActionVisitorTemplateEnforceV2<StolateInfo> {
	
	public VisiStolateEnforceValidTo(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StolateInfo enforceHook(StolateInfo recordInfo) {
		InfoSetter<StolateInfo> attrSetter = new StolateSetterValidTo();
		return attrSetter.setAttr(recordInfo);
	}
}
