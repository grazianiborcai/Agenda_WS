package br.com.mind5.business.storeTextDefault.model.action;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorextaultDaoSelect extends ActionStdTemplate<StorextaultInfo> {

	public StdStorextaultDaoSelect(DeciTreeOption<StorextaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StorextaultInfo> buildVisitorHook(DeciTreeOption<StorextaultInfo> option) {
		return new VisiStorextaultDaoSelect(option);
	}
}
