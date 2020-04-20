package br.com.mind5.masterData.materialType.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialType.model.action.StdMatypeDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatypeCheckExist extends ModelCheckerTemplateActionV2<MatypeInfo, MatypeInfo> {
	
	public MatypeCheckExist(ModelCheckerOption option) {
		super(option, MatypeInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatypeInfo> buildActionHook(DeciTreeOption<MatypeInfo> option) {
		ActionStdV1<MatypeInfo> select = new StdMatypeDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TYPE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TYPE_NOT_FOUND;
	}
}
