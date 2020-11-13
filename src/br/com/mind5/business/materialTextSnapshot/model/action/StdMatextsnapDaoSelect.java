package br.com.mind5.business.materialTextSnapshot.model.action;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextsnapDaoSelect extends ActionStdTemplate<MatextsnapInfo> {

	public StdMatextsnapDaoSelect(DeciTreeOption<MatextsnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatextsnapInfo> buildVisitorHook(DeciTreeOption<MatextsnapInfo> option) {
		return new VisiMatextsnapDaoSelect(option);
	}
}
