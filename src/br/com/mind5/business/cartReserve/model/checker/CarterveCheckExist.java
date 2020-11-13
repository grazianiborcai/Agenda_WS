package br.com.mind5.business.cartReserve.model.checker;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.decisionTree.RootCarterveSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CarterveCheckExist extends ModelCheckerTemplateAction<CarterveInfo, CarterveInfo> {
	
	public CarterveCheckExist(ModelCheckerOption option) {
		super(option, CarterveInfo.class);
	}
	

	
	@Override protected ActionStd<CarterveInfo> buildActionHook(DeciTreeOption<CarterveInfo> option) {
		ActionStd<CarterveInfo> select = new RootCarterveSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CART_RESERVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_RESERVE_NOT_FOUND;
	}
}
