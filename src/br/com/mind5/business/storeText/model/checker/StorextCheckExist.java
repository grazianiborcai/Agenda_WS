package br.com.mind5.business.storeText.model.checker;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.StdStorextDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextCheckExist extends ModelCheckerTemplateActionV2<StorextInfo, StorextInfo> {	
	
	public StorextCheckExist(ModelCheckerOption option) {
		super(option, StorextInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StorextInfo> buildActionHook(DeciTreeOption<StorextInfo> option) {
		ActionStdV1<StorextInfo> select = new StdStorextDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_TEXT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_NOT_FOUND;
	}
}
