package br.com.gda.business.phone.model;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PhoneModelSelect extends ModelTemplate<PhoneInfo> {

	public PhoneModelSelect(PhoneInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PhoneInfo> getDecisionTreeHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
