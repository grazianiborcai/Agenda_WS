package br.com.mind5.business.storeFavoriteSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;

public final class StdStoritarchDaoSelect extends ActionStdTemplate<StoritarchInfo> {

	public StdStoritarchDaoSelect(DeciTreeOption<StoritarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoritarchInfo> buildVisitorHook(DeciTreeOption<StoritarchInfo> option) {
		return new VisiStoritarchDaoSelect(option);
	}
}
