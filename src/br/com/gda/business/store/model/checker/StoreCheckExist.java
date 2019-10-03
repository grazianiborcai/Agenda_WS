package br.com.gda.business.store.model.checker;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.StdStoreSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreCheckExist extends ModelCheckerTemplateActionV2<StoreInfo, StoreInfo> {
	
	public StoreCheckExist(ModelCheckerOption option) {
		super(option, StoreInfo.class);
	}
	
	
	
	@Override protected ActionStd<StoreInfo> buildActionHook(DeciTreeOption<StoreInfo> option) {
		ActionStd<StoreInfo> select = new StdStoreSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_NOT_FOUND;
	}
}
