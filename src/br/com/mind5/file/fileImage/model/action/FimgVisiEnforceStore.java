package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgSetterStore;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgVisiEnforceStore extends ActionVisitorTemplateEnforce<FimgInfo> {
	
	public FimgVisiEnforceStore(DeciTreeOption<FimgInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected FimgInfo enforceHook(FimgInfo recordInfo) {
		InfoSetter<FimgInfo> attrSetter = new FimgSetterStore();
		return attrSetter.setAttr(recordInfo);
	}
}
