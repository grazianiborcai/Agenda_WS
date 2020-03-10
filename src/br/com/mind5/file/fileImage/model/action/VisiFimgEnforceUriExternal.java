package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgSetterUriExternal;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiFimgEnforceUriExternal extends ActionVisitorTemplateEnforce<FimgInfo> {
	
	@Override protected FimgInfo enforceHook(FimgInfo recordInfo) {
		InfoSetter<FimgInfo> attrSetter = new FimgSetterUriExternal();
		return attrSetter.setAttr(recordInfo);
	}
}
