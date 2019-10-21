package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.BusinessInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootBusinessSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BusinessModelSelect extends ModelTemplate<BusinessInfo> {

	public BusinessModelSelect(BusinessInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<BusinessInfo> getDecisionTreeHook(DeciTreeOption<BusinessInfo> option) {
		return new RootBusinessSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
