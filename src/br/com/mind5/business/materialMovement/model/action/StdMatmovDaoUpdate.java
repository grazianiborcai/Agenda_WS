package br.com.mind5.business.materialMovement.model.action;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatmovDaoUpdate extends ActionStdTemplateV2<MatmovInfo> {

	public StdMatmovDaoUpdate(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatmovInfo> buildVisitorHook(DeciTreeOption<MatmovInfo> option) {
		return new VisiMatmovDaoUpdate(option);
	}
}
