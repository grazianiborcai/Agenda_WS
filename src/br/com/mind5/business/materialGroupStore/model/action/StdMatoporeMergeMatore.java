package br.com.mind5.business.materialGroupStore.model.action;

import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatoporeMergeMatore extends ActionStdTemplate<MatoporeInfo> {

	public StdMatoporeMergeMatore(DeciTreeOption<MatoporeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatoporeInfo> buildVisitorHook(DeciTreeOption<MatoporeInfo> option) {
		return new VisiMatoporeMergeMatore(option);
	}
}
