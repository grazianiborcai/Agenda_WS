package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatSelect;
import br.com.mind5.business.material.model.action.StdMatEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatCheckExist extends ModelCheckerTemplateActionV2<MatInfo, MatInfo> {	
	
	public MatCheckExist(ModelCheckerOption option) {
		super(option, MatInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatInfo> buildActionHook(DeciTreeOption<MatInfo> option) {
		ActionStd<MatInfo> enforceKey = new StdMatEnforceKey(option);
		ActionLazy<MatInfo> select = new LazyMatSelect(option.conn, option.schemaName);
		
		enforceKey.addPostAction(select);
		return enforceKey;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_NOT_FOUND;
	}
}
