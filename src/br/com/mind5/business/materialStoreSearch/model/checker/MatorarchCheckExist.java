package br.com.mind5.business.materialStoreSearch.model.checker;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.model.decisionTree.RootMatorarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatorarchCheckExist extends ModelCheckerTemplateAction<MatorarchInfo, MatorarchInfo> {
	
	public MatorarchCheckExist(ModelCheckerOption option) {
		super(option, MatorarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatorarchInfo> buildActionHook(DeciTreeOption<MatorarchInfo> option) {
		ActionStd<MatorarchInfo> select = new RootMatorarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_STORE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STORE_SEARCH_NOT_FOUND;
	}
}
