package br.com.mind5.business.feeDefault.model.action;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeedefEnforceCategServ extends ActionStdTemplate<FeedefInfo> {

	public StdFeedefEnforceCategServ(DeciTreeOption<FeedefInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FeedefInfo> buildVisitorHook(DeciTreeOption<FeedefInfo> option) {
		return new VisiFeedefEnforceCategServ(option);
	}
}
