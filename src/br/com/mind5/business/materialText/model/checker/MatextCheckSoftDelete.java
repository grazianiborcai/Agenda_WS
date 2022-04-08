package br.com.mind5.business.materialText.model.checker;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.MatextVisiDaoSelect;
import br.com.mind5.business.materialText.model.action.MatextVisiEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextCheckSoftDelete extends ModelCheckerTemplateAction<MatextInfo, MatextInfo> {
	
	public MatextCheckSoftDelete(ModelCheckerOption option) {
		super(option, MatextInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatextInfo> buildActionHook(DeciTreeOption<MatextInfo> option) {
		ActionStd<MatextInfo> enforceDel = new ActionStdCommom<MatextInfo>(option, MatextVisiEnforceDel.class);
		ActionLazy<MatextInfo> select = new ActionLazyCommom<MatextInfo>(option, MatextVisiDaoSelect.class);
		
		enforceDel.addPostAction(select);
		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TEXT_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_NOT_FLAGGED_AS_DELETED;
	}
}
