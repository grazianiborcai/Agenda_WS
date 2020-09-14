package br.com.mind5.business.storeFavoriteSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;

public final class StdStoritarchDaoSelect extends ActionStdTemplateV2<StoritarchInfo> {

	public StdStoritarchDaoSelect(DeciTreeOption<StoritarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StoritarchInfo> buildVisitorHook(DeciTreeOption<StoritarchInfo> option) {
		return new VisiStoritarchDaoSelect(option);
	}
}
