package br.com.mind5.file.fileImageSearch.model.action;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchSetterOwner;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimarchEnforceOwner extends ActionVisitorTemplateEnforceV2<FimarchInfo> {
	
	public VisiFimarchEnforceOwner(DeciTreeOption<FimarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected FimarchInfo enforceHook(FimarchInfo recordInfo) {
		InfoSetter<FimarchInfo> attrSetter = new FimarchSetterOwner();
		return attrSetter.setAttr(recordInfo);
	}
}
