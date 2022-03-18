package br.com.mind5.business.material.model;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.MatRootDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatModelDelete extends ModelTemplate<MatInfo> {

	public MatModelDelete(MatInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatInfo> getDecisionTreeHook(DeciTreeOption<MatInfo> option) {
		return new MatRootDelete(option);
	}
}
