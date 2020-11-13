package br.com.mind5.masterData.materialType.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialType.model.action.StdMatypeDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatypeCheckExist extends ModelCheckerTemplateAction<MatypeInfo, MatypeInfo> {
	
	public MatypeCheckExist(ModelCheckerOption option) {
		super(option, MatypeInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatypeInfo> buildActionHook(DeciTreeOption<MatypeInfo> option) {
		ActionStd<MatypeInfo> select = new StdMatypeDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TYPE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TYPE_NOT_FOUND;
	}
}
