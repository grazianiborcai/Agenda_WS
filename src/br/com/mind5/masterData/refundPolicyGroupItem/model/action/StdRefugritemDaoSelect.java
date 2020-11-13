package br.com.mind5.masterData.refundPolicyGroupItem.model.action;

import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefugritemDaoSelect extends ActionStdTemplate<RefugritemInfo> {

	public StdRefugritemDaoSelect(DeciTreeOption<RefugritemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<RefugritemInfo> buildVisitorHook(DeciTreeOption<RefugritemInfo> option) {
		return new VisiRefugritemDaoSelect(option);
	}
}
