package br.com.mind5.masterData.businessArea.model.action;

import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdBusareaDaoSelect extends ActionStdTemplate<BusareaInfo> {

	public StdBusareaDaoSelect(DeciTreeOption<BusareaInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<BusareaInfo> buildVisitorHook(DeciTreeOption<BusareaInfo> option) {
		return new VisiBusareaDaoSelect(option);
	}
}
