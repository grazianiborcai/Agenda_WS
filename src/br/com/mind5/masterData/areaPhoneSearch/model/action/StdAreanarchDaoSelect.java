package br.com.mind5.masterData.areaPhoneSearch.model.action;

import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAreanarchDaoSelect extends ActionStdTemplateV2<AreanarchInfo> {

	public StdAreanarchDaoSelect(DeciTreeOption<AreanarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<AreanarchInfo> buildVisitorHook(DeciTreeOption<AreanarchInfo> option) {
		return new VisiAreanarchDaoSelect(option);
	}
}
