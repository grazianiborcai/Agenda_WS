package br.com.mind5.business.storeNearby.model.checker;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.decisionTree.RootStorbySelectHash03;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyCheckExistHash03 extends ModelCheckerTemplateActionV2<StorbyInfo, StorbyInfo> {
	
	public StorbyCheckExistHash03(ModelCheckerOption option) {
		super(option, StorbyInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StorbyInfo> buildActionHook(DeciTreeOption<StorbyInfo> option) {
		ActionStdV1<StorbyInfo> selectHash03 = new RootStorbySelectHash03(option).toAction();
		return selectHash03;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_NEARBY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_NEARBY_NOT_FOUND;
	}
}
