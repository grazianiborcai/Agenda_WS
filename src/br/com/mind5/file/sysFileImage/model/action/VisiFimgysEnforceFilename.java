package br.com.mind5.file.sysFileImage.model.action;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.info.FimgysSetterFilename;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgysEnforceFilename extends ActionVisitorTemplateEnforce<FimgysInfo> {
	
	public VisiFimgysEnforceFilename(DeciTreeOption<FimgysInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected FimgysInfo enforceHook(FimgysInfo recordInfo) {
		InfoSetter<FimgysInfo> attrSetter = new FimgysSetterFilename();
		return attrSetter.setAttr(recordInfo);
	}
}
