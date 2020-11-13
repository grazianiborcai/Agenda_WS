package br.com.mind5.masterData.materialUnit.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.masterData.materialUnit.model.action.StdMatunitDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatunitCheckExist extends ModelCheckerTemplateAction<MatunitInfo, MatunitInfo> {
	
	public MatunitCheckExist(ModelCheckerOption option) {
		super(option, MatunitInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatunitInfo> buildActionHook(DeciTreeOption<MatunitInfo> option) {
		ActionStd<MatunitInfo> select = new StdMatunitDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_UNIT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_UNIT_NOT_FOUND;
	}
}
