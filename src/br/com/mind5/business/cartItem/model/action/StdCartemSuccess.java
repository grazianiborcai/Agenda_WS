package br.com.mind5.business.cartItem.model.action;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdCartemSuccess extends ActionStdSuccessTemplate<CartemInfo> {
	
	public StdCartemSuccess(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
}
