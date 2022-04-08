package br.com.mind5.business.materialStore.model;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.MatoreRootDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreModelDelete extends ModelTemplate<MatoreInfo> {
	
	public MatoreModelDelete(MatoreInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatoreInfo> getDecisionTreeHook(DeciTreeOption<MatoreInfo> option) {
		return new MatoreRootDelete(option);
	}
}
