package br.com.mind5.business.storeTextDefault.model.checker;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.storeTextDefault.model.action.StorextaultVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextaultCheckExist extends ModelCheckerTemplateAction<StorextaultInfo, StorextaultInfo> {
	
	public StorextaultCheckExist(ModelCheckerOption option) {
		super(option, StorextaultInfo.class);
	}
	
	
	
	@Override protected ActionStd<StorextaultInfo> buildActionHook(DeciTreeOption<StorextaultInfo> option) {
		ActionStd<StorextaultInfo> select = new ActionStdCommom<StorextaultInfo>(option, StorextaultVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_TEXT_DEFAULT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_DEFAULT_NOT_FOUND;
	}
}
