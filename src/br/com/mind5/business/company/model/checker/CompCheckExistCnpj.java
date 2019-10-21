package br.com.mind5.business.company.model.checker;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.companySearch.info.ComparchCopier;
import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.business.companySearch.model.action.StdComparchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompCheckExistCnpj extends ModelCheckerTemplateActionV2<CompInfo, ComparchInfo> {
	
	public CompCheckExistCnpj(ModelCheckerOption option) {
		super(option, ComparchInfo.class);
	}
	
	
	
	@Override protected ActionStd<ComparchInfo> buildActionHook(DeciTreeOption<ComparchInfo> option) {
		ActionStd<ComparchInfo> select = new StdComparchSelect(option);
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
