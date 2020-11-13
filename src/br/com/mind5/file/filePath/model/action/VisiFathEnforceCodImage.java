package br.com.mind5.file.filePath.model.action;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.info.FathSetterCodImage;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFathEnforceCodImage extends ActionVisitorTemplateEnforce<FathInfo> {
	
	public VisiFathEnforceCodImage(DeciTreeOption<FathInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected FathInfo enforceHook(FathInfo recordInfo) {
		InfoSetter<FathInfo> attrSetter = new FathSetterCodImage();
		return attrSetter.setAttr(recordInfo);
	}
}
