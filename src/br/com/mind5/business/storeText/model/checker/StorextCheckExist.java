package br.com.mind5.business.storeText.model.checker;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.StorextVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextCheckExist extends ModelCheckerTemplateAction<StorextInfo, StorextInfo> {	
	
	public StorextCheckExist(ModelCheckerOption option) {
		super(option, StorextInfo.class);
	}
	
	
	
	@Override protected ActionStd<StorextInfo> buildActionHook(DeciTreeOption<StorextInfo> option) {
		ActionStd<StorextInfo> select = new ActionStdCommom<StorextInfo>(option, StorextVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_TEXT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_NOT_FOUND;
	}
}
