package br.com.mind5.masterData.materialGroup.model.action;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatoupDaoSelect extends ActionStdTemplateV2<MatoupInfo> {

	public StdMatoupDaoSelect(DeciTreeOption<MatoupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatoupInfo> buildVisitorHook(DeciTreeOption<MatoupInfo> option) {
		return new VisiMatoupDaoSelect(option);
	}
}
