package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgSetterFilename;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgEnforceFilename extends ActionVisitorTemplateEnforceV2<FimgInfo> {
	
	public VisiFimgEnforceFilename(DeciTreeOption<FimgInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected FimgInfo enforceHook(FimgInfo recordInfo) {
		InfoSetter<FimgInfo> attrSetter = new FimgSetterFilename();
		return attrSetter.setAttr(recordInfo);
	}
}
