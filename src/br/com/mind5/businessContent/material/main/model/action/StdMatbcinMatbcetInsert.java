package br.com.mind5.businessContent.material.main.model.action;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatbcinMatbcetInsert extends ActionStdTemplateV2<MatbcinInfo> {

	public StdMatbcinMatbcetInsert(DeciTreeOption<MatbcinInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatbcinInfo> buildVisitorHook(DeciTreeOption<MatbcinInfo> option) {
		return new VisiMatbcinMatbcetInsert(option);
	}
}
