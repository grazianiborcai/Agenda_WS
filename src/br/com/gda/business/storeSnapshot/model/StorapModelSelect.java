package br.com.gda.business.storeSnapshot.model;


import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.business.storeSnapshot.model.decisionTree.RootStorapSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StorapModelSelect extends ModelTemplate<StorapInfo> {

	public StorapModelSelect(StorapInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StorapInfo> getDecisionTreeHook(DeciTreeOption<StorapInfo> option) {
		return new RootStorapSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
