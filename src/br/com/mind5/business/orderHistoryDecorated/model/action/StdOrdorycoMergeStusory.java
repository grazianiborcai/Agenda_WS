package br.com.mind5.business.orderHistoryDecorated.model.action;

import br.com.mind5.business.orderHistoryDecorated.info.OrdorycoInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdorycoMergeStusory extends ActionStdTemplate<OrdorycoInfo> {

	public StdOrdorycoMergeStusory(DeciTreeOption<OrdorycoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdorycoInfo> buildVisitorHook(DeciTreeOption<OrdorycoInfo> option) {
		return new VisiOrdorycoMergeStusory(option);
	}
}
