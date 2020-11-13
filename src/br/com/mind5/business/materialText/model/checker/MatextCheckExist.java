package br.com.mind5.business.materialText.model.checker;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.StdMatextDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextCheckExist extends ModelCheckerTemplateAction<MatextInfo, MatextInfo> {	
	
	public MatextCheckExist(ModelCheckerOption option) {
		super(option, MatextInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatextInfo> buildActionHook(DeciTreeOption<MatextInfo> option) {
		ActionStd<MatextInfo> select = new StdMatextDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TEXT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_NOT_FOUND;
	}
}
