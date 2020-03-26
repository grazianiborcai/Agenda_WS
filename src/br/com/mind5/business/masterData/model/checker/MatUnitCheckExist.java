package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.masterData.model.action.StdMatUnitSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatUnitCheckExist extends ModelCheckerTemplateAction<MatUnitInfo, MatUnitInfo> {
	
	public MatUnitCheckExist(ModelCheckerOption option) {
		super(option, MatUnitInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatUnitInfo> buildActionHook(DeciTreeOption<MatUnitInfo> option) {
		ActionStd<MatUnitInfo> select = new StdMatUnitSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.UNIT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.UNIT_NOT_FOUND;
	}
}
