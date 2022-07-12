package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgSetterUri;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgVisiEnforceUri extends ActionVisitorTemplateEnforce<FimgInfo> {
	
	public FimgVisiEnforceUri(DeciTreeOption<FimgInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected FimgInfo enforceHook(FimgInfo recordInfo) {
		InfoSetter<FimgInfo> attrSetter = new FimgSetterUri();
		return attrSetter.setAttr(recordInfo);
	}
}
