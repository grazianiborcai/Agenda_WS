package br.com.mind5.business.orderSearch.model.action;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdarchDaoSelect extends ActionStdTemplateV2<OrdarchInfo> {

	public StdOrdarchDaoSelect(DeciTreeOption<OrdarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrdarchInfo> buildVisitorHook(DeciTreeOption<OrdarchInfo> option) {
		return new VisiOrdarchDaoSelect(option);
	}
}
