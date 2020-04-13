package br.com.mind5.business.materialList.model.action;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatlisDaoSelect extends ActionStdTemplateV2<MatlisInfo> {

	public StdMatlisDaoSelect(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatlisInfo> buildVisitorHook(DeciTreeOption<MatlisInfo> option) {
		return new VisiMatlisDaoSelect(option);
	}
}