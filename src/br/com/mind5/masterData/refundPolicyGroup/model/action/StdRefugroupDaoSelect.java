package br.com.mind5.masterData.refundPolicyGroup.model.action;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefugroupDaoSelect extends ActionStdTemplate<RefugroupInfo> {

	public StdRefugroupDaoSelect(DeciTreeOption<RefugroupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<RefugroupInfo> buildVisitorHook(DeciTreeOption<RefugroupInfo> option) {
		return new VisiRefugroupDaoSelect(option);
	}
}
