package br.com.mind5.masterData.orderStatusSearch.model.action;

import br.com.mind5.masterData.orderStatusSearch.info.OrderatarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderatarchDaoSelect extends ActionStdTemplate<OrderatarchInfo> {

	public StdOrderatarchDaoSelect(DeciTreeOption<OrderatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrderatarchInfo> buildVisitorHook(DeciTreeOption<OrderatarchInfo> option) {
		return new VisiOrderatarchDaoSelect(option);
	}
}
