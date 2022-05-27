package br.com.mind5.business.storeProspectSearch.model.action;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.business.storeProspectSearch.info.StoprarchSetterCreatedKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprarchVisiEnforceCreatedKey extends ActionVisitorTemplateEnforce<StoprarchInfo> {
	
	public StoprarchVisiEnforceCreatedKey(DeciTreeOption<StoprarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoprarchInfo enforceHook(StoprarchInfo recordInfo) {
		InfoSetter<StoprarchInfo> setter = new StoprarchSetterCreatedKey();
		return setter.setAttr(recordInfo);
	}
}
