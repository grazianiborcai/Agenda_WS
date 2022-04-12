package br.com.mind5.business.storeLeaveDate.model.action;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateSetterMonth;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateVisiEnforceMonth extends ActionVisitorTemplateEnforce<StolateInfo> {
	
	public StolateVisiEnforceMonth(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StolateInfo enforceHook(StolateInfo recordInfo) {
		InfoSetter<StolateInfo> attrSetter = new StolateSetterMonth();
		return attrSetter.setAttr(recordInfo);
	}
}
