package br.com.mind5.business.materialMovement.model.checker;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.StdMatmovSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatmovCheckExist extends ModelCheckerTemplateAction<MatmovInfo, MatmovInfo> {
	
	public MatmovCheckExist(ModelCheckerOption option) {
		super(option, MatmovInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatmovInfo> buildActionHook(DeciTreeOption<MatmovInfo> option) {
		ActionStdV1<MatmovInfo> select = new StdMatmovSelect(option);
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_MOV_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_MOV_NOT_FOUND;
	}
}
