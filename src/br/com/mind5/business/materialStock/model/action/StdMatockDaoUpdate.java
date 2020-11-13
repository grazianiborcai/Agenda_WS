package br.com.mind5.business.materialStock.model.action;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatockDaoUpdate extends ActionStdTemplateV2<MatockInfo> {

	public StdMatockDaoUpdate(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatockInfo> buildVisitorHook(DeciTreeOption<MatockInfo> option) {
		return new VisiMatockDaoUpdate(option);
	}
}
