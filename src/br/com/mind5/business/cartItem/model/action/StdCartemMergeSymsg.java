package br.com.mind5.business.cartItem.model.action;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartemMergeSymsg extends ActionStdTemplateV2<CartemInfo> {

	public StdCartemMergeSymsg(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CartemInfo> buildVisitorHook(DeciTreeOption<CartemInfo> option) {
		return new VisiCartemMergeSymsg(option);
	}
}
