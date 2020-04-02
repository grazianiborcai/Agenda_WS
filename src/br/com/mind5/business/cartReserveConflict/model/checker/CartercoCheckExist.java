package br.com.mind5.business.cartReserveConflict.model.checker;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.model.decisionTree.RootCartercoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartercoCheckExist extends ModelCheckerTemplateAction<CartercoInfo, CartercoInfo> {
	
	public CartercoCheckExist(ModelCheckerOption option) {
		super(option, CartercoInfo.class);
	}
	

	
	@Override protected ActionStdV1<CartercoInfo> buildActionHook(DeciTreeOption<CartercoInfo> option) {
		ActionStdV1<CartercoInfo> select = new RootCartercoSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CART_RESERVE_CONFLICT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_RESERVE_CONFLICT_NOT_FOUND;
	}
}
