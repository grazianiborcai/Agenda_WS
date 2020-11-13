package br.com.mind5.business.refundPolicyStore.model.action;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefuporeMergeToSelect extends ActionStdTemplate<RefuporeInfo> {
	
	public StdRefuporeMergeToSelect(DeciTreeOption<RefuporeInfo> option) {			
		super(option); 
	}
	
	
	
	protected ActionVisitor<RefuporeInfo> buildVisitorHook(DeciTreeOption<RefuporeInfo> option) {
		return new VisiRefuporeMergeToSelect(option);
	}
}
