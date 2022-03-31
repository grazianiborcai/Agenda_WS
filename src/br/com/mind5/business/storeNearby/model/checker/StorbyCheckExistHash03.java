package br.com.mind5.business.storeNearby.model.checker;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.decisionTree.StorbyRootSelectHash03;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyCheckExistHash03 extends ModelCheckerTemplateAction<StorbyInfo, StorbyInfo> {
	
	public StorbyCheckExistHash03(ModelCheckerOption option) {
		super(option, StorbyInfo.class);
	}
	
	
	
	@Override protected ActionStd<StorbyInfo> buildActionHook(DeciTreeOption<StorbyInfo> option) {
		ActionStd<StorbyInfo> selectHash03 = new StorbyRootSelectHash03(option).toAction();
		return selectHash03;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_NEARBY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_NEARBY_NOT_FOUND;
	}
}
