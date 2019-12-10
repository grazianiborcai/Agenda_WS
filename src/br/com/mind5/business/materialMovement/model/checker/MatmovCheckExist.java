package br.com.mind5.business.materialMovement.model.checker;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovSelect;
import br.com.mind5.business.materialMovement.model.action.StdMatmovEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatmovCheckExist extends ModelCheckerTemplateActionV2<MatmovInfo, MatmovInfo> {
	
	public MatmovCheckExist(ModelCheckerOption option) {
		super(option, MatmovInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatmovInfo> buildActionHook(DeciTreeOption<MatmovInfo> option) {
		ActionStd<MatmovInfo> enforceKey = new StdMatmovEnforceKey(option);
		ActionLazy<MatmovInfo> select = new LazyMatmovSelect(option.conn, option.schemaName);
		
		enforceKey.addPostAction(select);		
		return enforceKey;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_MOV_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_MOV_NOT_FOUND;
	}
}
