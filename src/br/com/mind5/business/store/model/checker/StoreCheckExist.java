package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StdStoreSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreCheckExist extends ModelCheckerTemplateActionV2<StoreInfo, StoreInfo> {
	
	public StoreCheckExist(ModelCheckerOption option) {
		super(option, StoreInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StoreInfo> buildActionHook(DeciTreeOption<StoreInfo> option) {
		ActionStdV1<StoreInfo> select = new StdStoreSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_NOT_FOUND;
	}
}
