package br.com.gda.business.phone.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneUpdate;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PhoneModelUpdate extends ModelTemplate<PhoneInfo> {

	public PhoneModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, PhoneInfo.class);
	}
	
	
	
	@Override protected DeciTree<PhoneInfo> getDecisionTreeHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneUpdate(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
