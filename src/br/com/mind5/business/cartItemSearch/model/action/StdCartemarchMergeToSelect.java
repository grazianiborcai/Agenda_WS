package br.com.mind5.business.cartItemSearch.model.action;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartemarchMergeToSelect extends ActionStdTemplateV2<CartemarchInfo> {

	public StdCartemarchMergeToSelect(DeciTreeOption<CartemarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CartemarchInfo> buildVisitorHook(DeciTreeOption<CartemarchInfo> option) {
		return new VisiCartemarchMergeToSelect(option);
	}
}
