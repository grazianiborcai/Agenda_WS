package br.com.mind5.masterData.refundPolicyGroupItemSearch.model.action;

import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefugritarchDaoSelect extends ActionStdTemplate<RefugritarchInfo> {

	public StdRefugritarchDaoSelect(DeciTreeOption<RefugritarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<RefugritarchInfo> buildVisitorHook(DeciTreeOption<RefugritarchInfo> option) {
		return new VisiRefugritarchDaoSelect(option);
	}
}
