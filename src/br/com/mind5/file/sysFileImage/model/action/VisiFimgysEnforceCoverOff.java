package br.com.mind5.file.sysFileImage.model.action;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.info.FimgysSetterCoverOff;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgysEnforceCoverOff extends ActionVisitorTemplateEnforce<FimgysInfo> {
	
	public VisiFimgysEnforceCoverOff(DeciTreeOption<FimgysInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected FimgysInfo enforceHook(FimgysInfo recordInfo) {
		InfoSetter<FimgysInfo> attrSetter = new FimgysSetterCoverOff();
		return attrSetter.setAttr(recordInfo);
	}
}
