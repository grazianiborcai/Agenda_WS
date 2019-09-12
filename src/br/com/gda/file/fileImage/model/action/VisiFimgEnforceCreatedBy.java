package br.com.gda.file.fileImage.model.action;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.info.FimgSetterCreatedBy;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFimgEnforceCreatedBy extends ActionVisitorTemplateEnforce<FimgInfo> {
	
	@Override protected FimgInfo enforceHook(FimgInfo recordInfo) {
		InfoSetter<FimgInfo> attrSetter = new FimgSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
