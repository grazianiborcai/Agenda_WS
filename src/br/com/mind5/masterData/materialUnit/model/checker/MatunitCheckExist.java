package br.com.mind5.masterData.materialUnit.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.masterData.materialUnit.model.action.StdMatunitDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatunitCheckExist extends ModelCheckerTemplateActionV2<MatunitInfo, MatunitInfo> {
	
	public MatunitCheckExist(ModelCheckerOption option) {
		super(option, MatunitInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatunitInfo> buildActionHook(DeciTreeOption<MatunitInfo> option) {
		ActionStdV1<MatunitInfo> select = new StdMatunitDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.UNIT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.UNIT_NOT_FOUND;
	}
}
