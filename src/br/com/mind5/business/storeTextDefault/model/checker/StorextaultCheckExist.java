package br.com.mind5.business.storeTextDefault.model.checker;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.storeTextDefault.model.action.StdStorextaultDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextaultCheckExist extends ModelCheckerTemplateActionV2<StorextaultInfo, StorextaultInfo> {
	
	public StorextaultCheckExist(ModelCheckerOption option) {
		super(option, StorextaultInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<StorextaultInfo> buildActionHook(DeciTreeOption<StorextaultInfo> option) {
		ActionStdV2<StorextaultInfo> select = new StdStorextaultDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_TEXT_DEFAULT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_DEFAULT_NOT_FOUND;
	}
}
