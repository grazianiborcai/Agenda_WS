package br.com.mind5.file.sysFileImage.model.action;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.info.FimgysSetterUriExternal;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgysEnforceUriExternal extends ActionVisitorTemplateEnforce<FimgysInfo> {
	
	public VisiFimgysEnforceUriExternal(DeciTreeOption<FimgysInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected FimgysInfo enforceHook(FimgysInfo recordInfo) {
		InfoSetter<FimgysInfo> attrSetter = new FimgysSetterUriExternal();
		return attrSetter.setAttr(recordInfo);
	}
}
