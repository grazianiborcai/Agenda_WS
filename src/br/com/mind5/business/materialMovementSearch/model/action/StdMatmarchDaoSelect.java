package br.com.mind5.business.materialMovementSearch.model.action;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatmarchDaoSelect extends ActionStdTemplateV2<MatmarchInfo> {

	public StdMatmarchDaoSelect(DeciTreeOption<MatmarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatmarchInfo> buildVisitorHook(DeciTreeOption<MatmarchInfo> option) {
		return new VisiMatmarchDaoSelect(option);
	}
}
