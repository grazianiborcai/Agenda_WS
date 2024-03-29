package br.com.mind5.discount.discountStore.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.decisionTree.DisoreRootSelectActive;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoreCheckExistValid extends ModelCheckerTemplateAction<DisoreInfo, DisoreInfo> {
	
	public DisoreCheckExistValid(ModelCheckerOption option) {
		super(option, DisoreInfo.class);
	}
	
	
	
	@Override protected ActionStd<DisoreInfo> buildActionHook(DeciTreeOption<DisoreInfo> option) {
		ActionStd<DisoreInfo> select = new DisoreRootSelectActive(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.DISCOUNT_STORE_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_STORE_IS_INVALID;
	}
}
