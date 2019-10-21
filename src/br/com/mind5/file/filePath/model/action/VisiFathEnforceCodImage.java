package br.com.mind5.file.filePath.model.action;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.info.FathSetterCodImage;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiFathEnforceCodImage extends ActionVisitorTemplateEnforce<FathInfo> {
	
	@Override protected FathInfo enforceHook(FathInfo recordInfo) {
		InfoSetter<FathInfo> attrSetter = new FathSetterCodImage();
		return attrSetter.setAttr(recordInfo);
	}
}
