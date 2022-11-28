package br.com.mind5.masterData.materialGroupOwner.model;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.decisionTree.MatoupowRootActivate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowModelActivate extends ModelTemplate<MatoupowInfo> {

	public MatoupowModelActivate(MatoupowInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatoupowInfo> getDecisionTreeHook(DeciTreeOption<MatoupowInfo> option) {
		return new MatoupowRootActivate(option);
	}
}
