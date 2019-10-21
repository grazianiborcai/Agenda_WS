package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.EntityCategInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootEntityCategSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EntityCategModelSelect extends ModelTemplate<EntityCategInfo> {

	public EntityCategModelSelect(EntityCategInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EntityCategInfo> getDecisionTreeHook(DeciTreeOption<EntityCategInfo> option) {
		return new RootEntityCategSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
