package br.com.mind5.masterData.materialUnit.model.action;

import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatunitDaoSelect extends ActionStdTemplateV2<MatunitInfo> {

	public StdMatunitDaoSelect(DeciTreeOption<MatunitInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatunitInfo> buildVisitorHook(DeciTreeOption<MatunitInfo> option) {
		return new VisiMatunitDaoSelect(option);
	}
}
