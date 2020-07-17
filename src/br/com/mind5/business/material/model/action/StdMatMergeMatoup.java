package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatMergeMatoup extends ActionStdTemplateV2<MatInfo> {

	public StdMatMergeMatoup(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatInfo> buildVisitorHook(DeciTreeOption<MatInfo> option) {
		return new VisiMatMergeMatoup(option);
	}
}
