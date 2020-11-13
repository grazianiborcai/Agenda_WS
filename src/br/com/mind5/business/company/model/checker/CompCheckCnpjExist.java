package br.com.mind5.business.company.model.checker;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.companySearch.info.ComparchCopier;
import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.business.companySearch.model.decisionTree.RootComparchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompCheckCnpjExist extends ModelCheckerTemplateAction<CompInfo, ComparchInfo> {
	
	public CompCheckCnpjExist(ModelCheckerOption option) {
		super(option, ComparchInfo.class);
	}
	
	
	
	@Override protected ActionStd<ComparchInfo> buildActionHook(DeciTreeOption<ComparchInfo> option) {
		ActionStd<ComparchInfo> select = new RootComparchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<ComparchInfo> toActionClassHook(List<CompInfo> recordInfos) {
		return ComparchCopier.copyFromComp(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COMPANY_CNPJ_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_CNPJ_NOT_FOUND;
	}
}
