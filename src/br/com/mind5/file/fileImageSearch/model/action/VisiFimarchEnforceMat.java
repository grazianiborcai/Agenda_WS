package br.com.mind5.file.fileImageSearch.model.action;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchSetterMat;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiFimarchEnforceMat extends ActionVisitorTemplateEnforce<FimarchInfo> {
	
	@Override protected FimarchInfo enforceHook(FimarchInfo recordInfo) {
		InfoSetter<FimarchInfo> attrSetter = new FimarchSetterMat();
		return attrSetter.setAttr(recordInfo);
	}
}
