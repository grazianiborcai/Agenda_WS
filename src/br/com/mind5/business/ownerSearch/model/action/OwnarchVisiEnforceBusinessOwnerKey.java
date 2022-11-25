package br.com.mind5.business.ownerSearch.model.action;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.info.OwnarchSetterBusinessOwnerKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnarchVisiEnforceBusinessOwnerKey extends ActionVisitorTemplateEnforce<OwnarchInfo> {
	
	public OwnarchVisiEnforceBusinessOwnerKey(DeciTreeOption<OwnarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OwnarchInfo enforceHook(OwnarchInfo recordInfo) {
		InfoSetter<OwnarchInfo> attrSetter = new OwnarchSetterBusinessOwnerKey();
		return attrSetter.setAttr(recordInfo);
	}
}
