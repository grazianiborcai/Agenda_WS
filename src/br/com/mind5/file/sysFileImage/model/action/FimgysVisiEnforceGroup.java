package br.com.mind5.file.sysFileImage.model.action;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.info.FimgysSetterGroup;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysVisiEnforceGroup extends ActionVisitorTemplateEnforce<FimgysInfo> {
	
	public FimgysVisiEnforceGroup(DeciTreeOption<FimgysInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected FimgysInfo enforceHook(FimgysInfo recordInfo) {
		InfoSetter<FimgysInfo> attrSetter = new FimgysSetterGroup();
		return attrSetter.setAttr(recordInfo);
	}
}
