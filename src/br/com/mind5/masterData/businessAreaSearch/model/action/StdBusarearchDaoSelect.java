package br.com.mind5.masterData.businessAreaSearch.model.action;

import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdBusarearchDaoSelect extends ActionStdTemplateV2<BusarearchInfo> {

	public StdBusarearchDaoSelect(DeciTreeOption<BusarearchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<BusarearchInfo> buildVisitorHook(DeciTreeOption<BusarearchInfo> option) {
		return new VisiBusarearchDaoSelect(option);
	}
}
