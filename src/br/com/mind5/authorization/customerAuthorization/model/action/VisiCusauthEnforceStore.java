package br.com.mind5.authorization.customerAuthorization.model.action;

import br.com.mind5.authorization.customerAuthorization.info.CusauthInfo;
import br.com.mind5.authorization.customerAuthorization.info.CusauthSetterStore;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusauthEnforceStore extends ActionVisitorTemplateEnforceV2<CusauthInfo> {
	
	public VisiCusauthEnforceStore(DeciTreeOption<CusauthInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected CusauthInfo enforceHook(CusauthInfo recordInfo) {
		InfoSetter<CusauthInfo> attrSetter = new CusauthSetterStore();
		return attrSetter.setAttr(recordInfo);
	}
}
