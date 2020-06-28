package br.com.mind5.business.companyConflict.model.checker;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.business.companyConflict.model.action.StdCompcoDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompcoCheckExist extends ModelCheckerTemplateActionV2<CompcoInfo, CompcoInfo> {
	
	public CompcoCheckExist(ModelCheckerOption option) {
		super(option, CompcoInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CompcoInfo> buildActionHook(DeciTreeOption<CompcoInfo> option) {
		ActionStdV1<CompcoInfo> select = new StdCompcoDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COMPANY_CONFLICT_CNPJ_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_CONFLICT_CNPJ_NOT_FOUND;
	}
}
