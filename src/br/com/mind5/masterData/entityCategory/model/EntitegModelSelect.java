package br.com.mind5.masterData.entityCategory.model;

import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.masterData.entityCategory.model.decisionTree.RootEntitegSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EntitegModelSelect extends ModelTemplate<EntitegInfo> {

	public EntitegModelSelect(EntitegInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EntitegInfo> getDecisionTreeHook(DeciTreeOption<EntitegInfo> option) {
		return new RootEntitegSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
