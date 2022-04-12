package br.com.mind5.business.refundPolicy.model.action;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.info.RefupolSetterRHour;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupolVisiEnforceRHour extends ActionVisitorTemplateEnforce<RefupolInfo> {
	
	public RefupolVisiEnforceRHour(DeciTreeOption<RefupolInfo> option) {
		super(option);
	}
	
	
	
	@Override protected RefupolInfo enforceHook(RefupolInfo recordInfo) {
		InfoSetter<RefupolInfo> setter = new RefupolSetterRHour();
		return setter.setAttr(recordInfo);
	}
}
