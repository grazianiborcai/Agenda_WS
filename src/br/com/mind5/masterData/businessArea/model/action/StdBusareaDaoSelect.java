package br.com.mind5.masterData.businessArea.model.action;

import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdBusareaDaoSelect extends ActionStdTemplateV2<BusareaInfo> {

	public StdBusareaDaoSelect(DeciTreeOption<BusareaInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<BusareaInfo> buildVisitorHook(DeciTreeOption<BusareaInfo> option) {
		return new VisiBusareaDaoSelect(option);
	}
}
