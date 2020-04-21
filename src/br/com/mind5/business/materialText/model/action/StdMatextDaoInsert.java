package br.com.mind5.business.materialText.model.action;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextDaoInsert extends ActionStdTemplateV2<MatextInfo> {

	public StdMatextDaoInsert(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatextInfo> buildVisitorHook(DeciTreeOption<MatextInfo> option) {
		return new VisiMatextDaoInsert(option);
	}
}
