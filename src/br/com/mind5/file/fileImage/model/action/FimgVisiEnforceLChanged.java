package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgVisiEnforceLChanged extends ActionVisitorTemplateEnforce<FimgInfo> {
	
	public FimgVisiEnforceLChanged(DeciTreeOption<FimgInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected FimgInfo enforceHook(FimgInfo recordInfo) {
		InfoSetter<FimgInfo> attrSetter = new FimgSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
