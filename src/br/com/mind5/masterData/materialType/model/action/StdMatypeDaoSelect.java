package br.com.mind5.masterData.materialType.model.action;

import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatypeDaoSelect extends ActionStdTemplateV2<MatypeInfo> {

	public StdMatypeDaoSelect(DeciTreeOption<MatypeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatypeInfo> buildVisitorHook(DeciTreeOption<MatypeInfo> option) {
		return new VisiMatypeDaoSelect(option);
	}
}
