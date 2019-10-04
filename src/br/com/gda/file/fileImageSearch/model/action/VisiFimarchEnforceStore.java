package br.com.gda.file.fileImageSearch.model.action;

import br.com.gda.file.fileImageSearch.info.FimarchSetterStore;
import br.com.gda.file.fileImageSearch.info.FimarchInfo;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFimarchEnforceStore extends ActionVisitorTemplateEnforce<FimarchInfo> {
	
	@Override protected FimarchInfo enforceHook(FimarchInfo recordInfo) {
		InfoSetter<FimarchInfo> attrSetter = new FimarchSetterStore();
		return attrSetter.setAttr(recordInfo);
	}
}
