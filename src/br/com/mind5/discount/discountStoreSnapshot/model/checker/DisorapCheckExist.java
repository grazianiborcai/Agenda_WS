package br.com.mind5.discount.discountStoreSnapshot.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.discount.discountStoreSnapshot.model.action.StdDisorapDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisorapCheckExist extends ModelCheckerTemplateAction<DisorapInfo, DisorapInfo> {
	
	public DisorapCheckExist(ModelCheckerOption option) {
		super(option, DisorapInfo.class);
	}
	
	
	
	@Override protected ActionStd<DisorapInfo> buildActionHook(DeciTreeOption<DisorapInfo> option) {
		ActionStd<DisorapInfo> select = new StdDisorapDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.DISCOUNT_STORE_SNAP_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_STORE_SNAP_NOT_FOUND;
	}
}
