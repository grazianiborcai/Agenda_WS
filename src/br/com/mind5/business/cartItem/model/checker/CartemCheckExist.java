package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.CartemVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemCheckExist extends ModelCheckerTemplateAction<CartemInfo, CartemInfo> {
	
	public CartemCheckExist(ModelCheckerOption option) {
		super(option, CartemInfo.class);
	}
	

	
	@Override protected ActionStd<CartemInfo> buildActionHook(DeciTreeOption<CartemInfo> option) {
		ActionStd<CartemInfo> select = new ActionStdCommom<CartemInfo>(option, CartemVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CART_ITEM_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_ITEM_NOT_FOUND;
	}
}
