package br.com.mind5.discount.discountStoreSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.model.decisionTree.DisorarchRootSelectFirstTime;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisorarchCheckExistFirstTime extends ModelCheckerTemplateAction<DisorarchInfo, DisorarchInfo> {
	
	public DisorarchCheckExistFirstTime(ModelCheckerOption option) {
		super(option, DisorarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<DisorarchInfo> buildActionHook(DeciTreeOption<DisorarchInfo> option) {
		ActionStd<DisorarchInfo> select = new DisorarchRootSelectFirstTime(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.DISCOUNT_STORE_SEARCH_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_STORE_SEARCH_NOT_FOUND;
	}
}
