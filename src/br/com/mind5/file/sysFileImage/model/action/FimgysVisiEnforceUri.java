package br.com.mind5.file.sysFileImage.model.action;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.info.FimgysSetterUri;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysVisiEnforceUri extends ActionVisitorTemplateEnforce<FimgysInfo> {
	
	public FimgysVisiEnforceUri(DeciTreeOption<FimgysInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected FimgysInfo enforceHook(FimgysInfo recordInfo) {
		InfoSetter<FimgysInfo> attrSetter = new FimgysSetterUri();
		return attrSetter.setAttr(recordInfo);
	}
}
