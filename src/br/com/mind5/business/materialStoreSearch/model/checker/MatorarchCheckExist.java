package br.com.mind5.business.materialStoreSearch.model.checker;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.model.decisionTree.RootMatorarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatorarchCheckExist extends ModelCheckerTemplateActionV2<MatorarchInfo, MatorarchInfo> {
	
	public MatorarchCheckExist(ModelCheckerOption option) {
		super(option, MatorarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatorarchInfo> buildActionHook(DeciTreeOption<MatorarchInfo> option) {
		ActionStdV1<MatorarchInfo> select = new RootMatorarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_STORE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STORE_SEARCH_NOT_FOUND;
	}
}
