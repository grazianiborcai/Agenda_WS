package br.com.mind5.masterData.businessAreaSearch.model.action;

import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdBusarearchDaoSelect extends ActionStdTemplate<BusarearchInfo> {

	public StdBusarearchDaoSelect(DeciTreeOption<BusarearchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<BusarearchInfo> buildVisitorHook(DeciTreeOption<BusarearchInfo> option) {
		return new VisiBusarearchDaoSelect(option);
	}
}
