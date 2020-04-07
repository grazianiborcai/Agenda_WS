package br.com.mind5.business.company.model.checker;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.companyConflict.info.CompcoCopier;
import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.business.companyConflict.model.decisionTree.RootCompcoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompCheckCnpjExist extends ModelCheckerTemplateActionV2<CompInfo, CompcoInfo> {
	
	public CompCheckCnpjExist(ModelCheckerOption option) {
		super(option, CompcoInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CompcoInfo> buildActionHook(DeciTreeOption<CompcoInfo> option) {
		ActionStdV1<CompcoInfo> select = new RootCompcoSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<CompcoInfo> toActionClassHook(List<CompInfo> recordInfos) {
		return CompcoCopier.copyFromCompCnpj(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COMPANY_CNPJ_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_CNPJ_NOT_FOUND;
	}
}
