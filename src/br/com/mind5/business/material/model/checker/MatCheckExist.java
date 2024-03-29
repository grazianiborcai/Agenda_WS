package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.MatVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatCheckExist extends ModelCheckerTemplateAction<MatInfo, MatInfo> {	
	
	public MatCheckExist(ModelCheckerOption option) {
		super(option, MatInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatInfo> buildActionHook(DeciTreeOption<MatInfo> option) {
		ActionStd<MatInfo> select = new ActionStdCommom<MatInfo>(option, MatVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_NOT_FOUND;
	}
}
