package br.com.mind5.business.orderHistoryDecorated.model.action;

import br.com.mind5.business.orderHistoryDecorated.info.OrdorycoInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdorycoMergeOrdorySearchAuth extends ActionStdTemplate<OrdorycoInfo> {

	public StdOrdorycoMergeOrdorySearchAuth(DeciTreeOption<OrdorycoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdorycoInfo> buildVisitorHook(DeciTreeOption<OrdorycoInfo> option) {
		return new VisiOrdorycoMergeOrdorySearchAuth(option);
	}
}
