package br.com.mind5.business.materialMovement.model;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.decisionTree.RootMatmovSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatmovModelSelect extends ModelTemplate<MatmovInfo> {	
	
	public MatmovModelSelect(MatmovInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatmovInfo> getDecisionTreeHook(DeciTreeOption<MatmovInfo> option) {
		return new RootMatmovSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
