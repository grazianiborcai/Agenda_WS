package br.com.mind5.file.fileImageSearch.model.action;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchSetterOwner;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiFimarchEnforceOwner extends ActionVisitorTemplateEnforce<FimarchInfo> {
	
	@Override protected FimarchInfo enforceHook(FimarchInfo recordInfo) {
		InfoSetter<FimarchInfo> attrSetter = new FimarchSetterOwner();
		return attrSetter.setAttr(recordInfo);
	}
}
