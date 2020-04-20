package br.com.mind5.business.companyList.model.action;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdComplisDaoSelect extends ActionStdTemplateV2<ComplisInfo> {

	public StdComplisDaoSelect(DeciTreeOption<ComplisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<ComplisInfo> buildVisitorHook(DeciTreeOption<ComplisInfo> option) {
		return new VisiComplisDaoSelect(option);
	}
}
