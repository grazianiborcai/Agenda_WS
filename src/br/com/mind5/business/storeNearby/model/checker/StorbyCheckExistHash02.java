package br.com.mind5.business.storeNearby.model.checker;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.decisionTree.RootStorbySelectHash02;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyCheckExistHash02 extends ModelCheckerTemplateActionV2<StorbyInfo, StorbyInfo> {
	
	public StorbyCheckExistHash02(ModelCheckerOption option) {
		super(option, StorbyInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<StorbyInfo> buildActionHook(DeciTreeOption<StorbyInfo> option) {
		ActionStdV2<StorbyInfo> selectHash02 = new RootStorbySelectHash02(option).toAction();
		return selectHash02;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_NEARBY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_NEARBY_NOT_FOUND;
	}
}
