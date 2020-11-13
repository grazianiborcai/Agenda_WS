package br.com.mind5.masterData.areaPhoneSearch.model.action;

import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAreanarchDaoSelect extends ActionStdTemplate<AreanarchInfo> {

	public StdAreanarchDaoSelect(DeciTreeOption<AreanarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AreanarchInfo> buildVisitorHook(DeciTreeOption<AreanarchInfo> option) {
		return new VisiAreanarchDaoSelect(option);
	}
}
