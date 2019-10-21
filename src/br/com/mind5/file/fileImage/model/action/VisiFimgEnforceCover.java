package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgSetterCover;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiFimgEnforceCover extends ActionVisitorTemplateEnforce<FimgInfo> {
	
	@Override protected FimgInfo enforceHook(FimgInfo recordInfo) {
		InfoSetter<FimgInfo> attrSetter = new FimgSetterCover();
		return attrSetter.setAttr(recordInfo);
	}
}
