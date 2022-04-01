package br.com.mind5.business.companyConflict.model.checker;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.business.companyConflict.model.action.CompcoVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompcoCheckExist extends ModelCheckerTemplateAction<CompcoInfo, CompcoInfo> {
	
	public CompcoCheckExist(ModelCheckerOption option) {
		super(option, CompcoInfo.class);
	}
	
	
	
	@Override protected ActionStd<CompcoInfo> buildActionHook(DeciTreeOption<CompcoInfo> option) {
		ActionStd<CompcoInfo> select = new ActionStdCommom<CompcoInfo>(option, CompcoVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COMPANY_CONFLICT_CNPJ_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_CONFLICT_CNPJ_NOT_FOUND;
	}
}
