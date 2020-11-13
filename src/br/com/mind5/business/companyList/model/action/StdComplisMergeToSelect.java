package br.com.mind5.business.companyList.model.action;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdComplisMergeToSelect extends ActionStdTemplate<ComplisInfo> {

	public StdComplisMergeToSelect(DeciTreeOption<ComplisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<ComplisInfo> buildVisitorHook(DeciTreeOption<ComplisInfo> option) {
		return new VisiComplisMergeToSelect(option);
	}
}
