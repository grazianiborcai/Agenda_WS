package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgEnforceCreatedOn extends ActionVisitorTemplateEnforceV2<FimgInfo> {
	
	public VisiFimgEnforceCreatedOn(DeciTreeOption<FimgInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected FimgInfo enforceHook(FimgInfo recordInfo) {
		InfoSetter<FimgInfo> attrSetter = new FimgSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
