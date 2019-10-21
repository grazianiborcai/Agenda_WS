package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgSetterOwner;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiFimgEnforceOwner extends ActionVisitorTemplateEnforce<FimgInfo> {
	
	@Override protected FimgInfo enforceHook(FimgInfo recordInfo) {
		InfoSetter<FimgInfo> attrSetter = new FimgSetterOwner();
		return attrSetter.setAttr(recordInfo);
	}
}
