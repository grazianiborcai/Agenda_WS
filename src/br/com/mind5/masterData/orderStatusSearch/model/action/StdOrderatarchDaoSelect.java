package br.com.mind5.masterData.orderStatusSearch.model.action;

import br.com.mind5.masterData.orderStatusSearch.info.OrderatarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderatarchDaoSelect extends ActionStdTemplateV2<OrderatarchInfo> {

	public StdOrderatarchDaoSelect(DeciTreeOption<OrderatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrderatarchInfo> buildVisitorHook(DeciTreeOption<OrderatarchInfo> option) {
		return new VisiOrderatarchDaoSelect(option);
	}
}
