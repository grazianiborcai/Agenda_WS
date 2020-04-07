package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.StdCartemSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemCheckExist extends ModelCheckerTemplateActionV2<CartemInfo, CartemInfo> {
	
	public CartemCheckExist(ModelCheckerOption option) {
		super(option, CartemInfo.class);
	}
	

	
	@Override protected ActionStdV1<CartemInfo> buildActionHook(DeciTreeOption<CartemInfo> option) {
		ActionStdV1<CartemInfo> actionSelect = new StdCartemSelect(option);
		return actionSelect;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CART_ITEM_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_ITEM_NOT_FOUND;
	}
}
