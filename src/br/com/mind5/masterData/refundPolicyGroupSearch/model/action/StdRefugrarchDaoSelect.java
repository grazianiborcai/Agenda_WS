package br.com.mind5.masterData.refundPolicyGroupSearch.model.action;

import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefugrarchDaoSelect extends ActionStdTemplate<RefugrarchInfo> {

	public StdRefugrarchDaoSelect(DeciTreeOption<RefugrarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<RefugrarchInfo> buildVisitorHook(DeciTreeOption<RefugrarchInfo> option) {
		return new VisiRefugrarchDaoSelect(option);
	}
}
