package br.com.gda.business.person.model.checker;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.personSearch.info.PerarchCopier;
import br.com.gda.business.personSearch.info.PerarchInfo;
import br.com.gda.business.personSearch.model.decisionTree.RootPerarchSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PersonCheckExistCpf extends ModelCheckerTemplateActionV2<PersonInfo, PerarchInfo> {
	
	public PersonCheckExistCpf(ModelCheckerOption option) {
		super(option, PerarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<PerarchInfo> buildActionHook(DeciTreeOption<PerarchInfo> option) {		
		ActionStd<PerarchInfo> select = new RootPerarchSelect(option).toAction();		
		return select;
	}
	
	
	
	@Override protected List<PerarchInfo> toActionClassHook(List<PersonInfo> recordInfos) {
		return PerarchCopier.copyFromPersonCpf(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_CPF_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_CPF_NOT_FOUND;
	}
}
