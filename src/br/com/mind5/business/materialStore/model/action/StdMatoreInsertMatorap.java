package br.com.mind5.business.materialStore.model.action;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatoreInsertMatorap extends ActionStdTemplate<MatoreInfo> {

	public StdMatoreInsertMatorap(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatoreInfo> buildVisitorHook(DeciTreeOption<MatoreInfo> option) {
		return new VisiMatoreInsertMatorap(option);
	}
}
