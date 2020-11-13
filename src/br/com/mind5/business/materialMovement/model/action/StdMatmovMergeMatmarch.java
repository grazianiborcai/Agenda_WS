package br.com.mind5.business.materialMovement.model.action;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatmovMergeMatmarch extends ActionStdTemplate<MatmovInfo> {

	public StdMatmovMergeMatmarch(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatmovInfo> buildVisitorHook(DeciTreeOption<MatmovInfo> option) {
		return new VisiMatmovMergeMatmarch(option);
	}
}
