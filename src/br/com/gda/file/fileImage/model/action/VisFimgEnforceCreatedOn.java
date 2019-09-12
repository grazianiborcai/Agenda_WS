package br.com.gda.file.fileImage.model.action;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.info.FimgSetterCreatedOn;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisFimgEnforceCreatedOn extends ActionVisitorTemplateEnforce<FimgInfo> {
	
	@Override protected FimgInfo enforceHook(FimgInfo recordInfo) {
		InfoSetter<FimgInfo> attrSetter = new FimgSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
