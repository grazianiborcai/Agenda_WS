package br.com.mind5.business.storeSnapshot.model;


import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.decisionTree.RootStorapSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
