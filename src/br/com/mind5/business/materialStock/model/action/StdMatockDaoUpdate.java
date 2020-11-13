package br.com.mind5.business.materialStock.model.action;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatockDaoUpdate extends ActionStdTemplate<MatockInfo> {

	public StdMatockDaoUpdate(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatockInfo> buildVisitorHook(DeciTreeOption<MatockInfo> option) {
		return new VisiMatockDaoUpdate(option);
	}
}
