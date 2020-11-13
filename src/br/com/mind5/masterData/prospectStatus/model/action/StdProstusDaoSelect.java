package br.com.mind5.masterData.prospectStatus.model.action;

import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdProstusDaoSelect extends ActionStdTemplate<ProstusInfo> {

	public StdProstusDaoSelect(DeciTreeOption<ProstusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<ProstusInfo> buildVisitorHook(DeciTreeOption<ProstusInfo> option) {
		return new VisiProstusDaoSelect(option);
	}
}
