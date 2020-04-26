package br.com.mind5.business.cartItemSearch.model.action;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartemarchDaoSelect extends ActionStdTemplateV2<CartemarchInfo> {

	public StdCartemarchDaoSelect(DeciTreeOption<CartemarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CartemarchInfo> buildVisitorHook(DeciTreeOption<CartemarchInfo> option) {
		return new VisiCartemarchDaoSelect(option);
	}
}
