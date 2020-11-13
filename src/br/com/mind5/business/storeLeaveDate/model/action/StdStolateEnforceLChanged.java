package br.com.mind5.business.storeLeaveDate.model.action;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolateEnforceLChanged extends ActionStdTemplate<StolateInfo> {

	public StdStolateEnforceLChanged(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StolateInfo> buildVisitorHook(DeciTreeOption<StolateInfo> option) {
		return new VisiStolateEnforceLChanged(option);
	}
}
