package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.BusinessInfo;
import br.com.gda.business.masterData.model.decisionTree.RootBusinessSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
