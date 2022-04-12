package br.com.mind5.business.refundPolicy.model.action;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.info.RefupolSetterHasPassed;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupolVisiEnforceHasPassed extends ActionVisitorTemplateEnforce<RefupolInfo> {
	
	public RefupolVisiEnforceHasPassed(DeciTreeOption<RefupolInfo> option) {
		super(option);
	}
	
	
	
	@Override protected RefupolInfo enforceHook(RefupolInfo recordInfo) {
		InfoSetter<RefupolInfo> setter = new RefupolSetterHasPassed();
		return setter.setAttr(recordInfo);
	}
}
