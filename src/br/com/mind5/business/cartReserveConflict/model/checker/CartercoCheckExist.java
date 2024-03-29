package br.com.mind5.business.cartReserveConflict.model.checker;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.model.decisionTree.CartercoRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartercoCheckExist extends ModelCheckerTemplateAction<CartercoInfo, CartercoInfo> {
	
	public CartercoCheckExist(ModelCheckerOption option) {
		super(option, CartercoInfo.class);
	}
	

	
	@Override protected ActionStd<CartercoInfo> buildActionHook(DeciTreeOption<CartercoInfo> option) {
		ActionStd<CartercoInfo> select = new CartercoRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CART_RESERVE_CONFLICT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_RESERVE_CONFLICT_NOT_FOUND;
	}
}
