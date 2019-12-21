package br.com.mind5.file.fileImageSearch.model.action;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchSetterCus;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiFimarchEnforceCus extends ActionVisitorTemplateEnforce<FimarchInfo> {
	
	@Override protected FimarchInfo enforceHook(FimarchInfo recordInfo) {
		InfoSetter<FimarchInfo> attrSetter = new FimarchSetterCus();
		return attrSetter.setAttr(recordInfo);
	}
}
