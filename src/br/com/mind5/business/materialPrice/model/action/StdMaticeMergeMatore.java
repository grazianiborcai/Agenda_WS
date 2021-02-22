package br.com.mind5.business.materialPrice.model.action;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMaticeMergeMatore extends ActionStdTemplate<MaticeInfo> {

	public StdMaticeMergeMatore(DeciTreeOption<MaticeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MaticeInfo> buildVisitorHook(DeciTreeOption<MaticeInfo> option) {
		return new VisiMaticeMergeMatore(option);
	}
}
