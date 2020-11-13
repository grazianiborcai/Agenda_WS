package br.com.mind5.business.storeFavorite.model.checker;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.action.StdStoriteDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoriteCheckExist extends ModelCheckerTemplateActionV2<StoriteInfo, StoriteInfo> {
	
	public StoriteCheckExist(ModelCheckerOption option) {
		super(option, StoriteInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<StoriteInfo> buildActionHook(DeciTreeOption<StoriteInfo> option) {
		ActionStdV2<StoriteInfo> select = new StdStoriteDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_FAVORITE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_FAVORITE_NOT_FOUND;
	}
}
