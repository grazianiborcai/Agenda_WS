package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompSetterCnpj;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompEnforceCnpj extends ActionVisitorTemplateEnforce<CompInfo> {
	
	public VisiCompEnforceCnpj(DeciTreeOption<CompInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected CompInfo enforceHook(CompInfo recordInfo) {
		InfoSetter<CompInfo> attrSetter = new CompSetterCnpj();
		return attrSetter.setAttr(recordInfo);
	}
}
