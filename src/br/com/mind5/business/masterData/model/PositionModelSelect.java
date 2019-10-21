package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootPositionSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PositionModelSelect extends ModelTemplate<PositionInfo> {

	public PositionModelSelect(PositionInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PositionInfo> getDecisionTreeHook(DeciTreeOption<PositionInfo> option) {
		return new RootPositionSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
