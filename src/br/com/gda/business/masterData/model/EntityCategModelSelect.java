package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.EntityCategInfo;
import br.com.gda.business.masterData.model.decisionTree.RootEntityCategSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
