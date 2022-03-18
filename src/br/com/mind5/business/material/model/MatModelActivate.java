package br.com.mind5.business.material.model;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.MatRootActivate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatModelActivate extends ModelTemplate<MatInfo> {

	public MatModelActivate(MatInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatInfo> getDecisionTreeHook(DeciTreeOption<MatInfo> option) {
		return new MatRootActivate(option);
	}
}
