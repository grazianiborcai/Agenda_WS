package br.com.mind5.business.addressSearch.model.action;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.info.AddarchSetterStore;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddarchEnforceStore extends ActionVisitorTemplateEnforce<AddarchInfo> {
	
	public VisiAddarchEnforceStore(DeciTreeOption<AddarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected AddarchInfo enforceHook(AddarchInfo recordInfo) {
		InfoSetter<AddarchInfo> attrSetter = new AddarchSetterStore();
		return attrSetter.setAttr(recordInfo);
	}
}
