package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPositionSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
