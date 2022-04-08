package br.com.mind5.business.materialStore.model.checker;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.MatoreVisiDaoSelect;
import br.com.mind5.business.materialStore.model.action.MatoreVisiEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreCheckSoftDelete extends ModelCheckerTemplateAction<MatoreInfo, MatoreInfo> {
	
	public MatoreCheckSoftDelete(ModelCheckerOption option) {
		super(option, MatoreInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatoreInfo> buildActionHook(DeciTreeOption<MatoreInfo> option) {	
		ActionStd<MatoreInfo> enforceDel = new ActionStdCommom<MatoreInfo>(option, MatoreVisiEnforceDel.class);
		ActionLazy<MatoreInfo> select = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiDaoSelect.class);
		
		enforceDel.addPostAction(select);
		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_STORE_FLAGGED_AS_DELETED;
	}	
}
