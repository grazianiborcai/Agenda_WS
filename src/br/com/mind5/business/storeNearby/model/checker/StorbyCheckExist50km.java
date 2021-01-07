package br.com.mind5.business.storeNearby.model.checker;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.decisionTree.RootStorbySelect50km;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyCheckExist50km extends ModelCheckerTemplateAction<StorbyInfo, StorbyInfo> {
	
	public StorbyCheckExist50km(ModelCheckerOption option) {
		super(option, StorbyInfo.class);
	}
	
	
	
	@Override protected ActionStd<StorbyInfo> buildActionHook(DeciTreeOption<StorbyInfo> option) {
		ActionStd<StorbyInfo> select50km = new RootStorbySelect50km(option).toAction();
		return select50km;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_NEARBY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_NEARBY_NOT_FOUND;
	}
}
