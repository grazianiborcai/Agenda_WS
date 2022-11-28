package br.com.mind5.masterData.materialGroupOwner.model;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.decisionTree.MatoupowRootInactivate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowModelInactivate extends ModelTemplate<MatoupowInfo> {

	public MatoupowModelInactivate(MatoupowInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatoupowInfo> getDecisionTreeHook(DeciTreeOption<MatoupowInfo> option) {
		return new MatoupowRootInactivate(option);
	}
}
