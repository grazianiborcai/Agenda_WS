package br.com.mind5.business.cartItemSearch.model.action;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartemarchMergeToSelect extends ActionStdTemplate<CartemarchInfo> {

	public StdCartemarchMergeToSelect(DeciTreeOption<CartemarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CartemarchInfo> buildVisitorHook(DeciTreeOption<CartemarchInfo> option) {
		return new VisiCartemarchMergeToSelect(option);
	}
}
