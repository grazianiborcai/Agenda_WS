package br.com.mind5.business.materialStore.model.checker;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.StdMatoreDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreCheckExist extends ModelCheckerTemplateAction<MatoreInfo, MatoreInfo> {
	
	public MatoreCheckExist(ModelCheckerOption option) {
		super(option, MatoreInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatoreInfo> buildActionHook(DeciTreeOption<MatoreInfo> option) {		
		ActionStd<MatoreInfo> select = new StdMatoreDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_STORE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STORE_NOT_FOUND;
	}
}
