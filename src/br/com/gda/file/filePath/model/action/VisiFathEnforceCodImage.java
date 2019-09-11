package br.com.gda.file.filePath.model.action;

import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.file.filePath.info.FathSetterCodImage;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFathEnforceCodImage extends ActionVisitorTemplateEnforce<FathInfo> {
	
	@Override protected FathInfo enforceHook(FathInfo recordInfo) {
		InfoSetter<FathInfo> attrSetter = new FathSetterCodImage();
		return attrSetter.setAttr(recordInfo);
	}
}
