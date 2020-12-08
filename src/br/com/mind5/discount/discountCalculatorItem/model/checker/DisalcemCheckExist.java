package br.com.mind5.discount.discountCalculatorItem.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.discount.discountCalculatorItem.model.decisionTree.RootDisalcemSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisalcemCheckExist extends ModelCheckerTemplateAction<DisalcemInfo, DisalcemInfo> {
	
	public DisalcemCheckExist(ModelCheckerOption option) {
		super(option, DisalcemInfo.class);
	}
	
	
	
	@Override protected ActionStd<DisalcemInfo> buildActionHook(DeciTreeOption<DisalcemInfo> option) {
		ActionStd<DisalcemInfo> select = new RootDisalcemSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.DISCOUNT_CALC_ITEM_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_CALC_ITEM_NOT_FOUND;
	}
}
