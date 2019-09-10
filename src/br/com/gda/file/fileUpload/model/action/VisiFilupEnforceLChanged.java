package br.com.gda.file.fileUpload.model.action;

import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.file.fileUpload.info.FilupSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFilupEnforceLChanged extends ActionVisitorTemplateEnforce<FilupInfo> {
	
	@Override protected FilupInfo enforceHook(FilupInfo recordInfo) {
		InfoSetter<FilupInfo> attrSetter = new FilupSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
