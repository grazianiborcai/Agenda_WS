package br.com.mind5.masterData.position.model;

import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.masterData.position.model.decisionTree.PositionRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PositionModelSelect extends ModelTemplate<PositionInfo> {

	public PositionModelSelect(PositionInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PositionInfo> getDecisionTreeHook(DeciTreeOption<PositionInfo> option) {
		return new PositionRootSelect(option);
	}
}
