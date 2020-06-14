package br.com.mind5.masterData.prospectStatus.model.action;

import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdProstusDaoSelect extends ActionStdTemplateV2<ProstusInfo> {

	public StdProstusDaoSelect(DeciTreeOption<ProstusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<ProstusInfo> buildVisitorHook(DeciTreeOption<ProstusInfo> option) {
		return new VisiProstusDaoSelect(option);
	}
}
