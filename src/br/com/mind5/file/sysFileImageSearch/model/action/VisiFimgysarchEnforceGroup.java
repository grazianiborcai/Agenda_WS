package br.com.mind5.file.sysFileImageSearch.model.action;

import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.file.sysFileImageSearch.info.FimgysarchSetterGroup;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgysarchEnforceGroup extends ActionVisitorTemplateEnforce<FimgysarchInfo> {
	
	public VisiFimgysarchEnforceGroup(DeciTreeOption<FimgysarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected FimgysarchInfo enforceHook(FimgysarchInfo recordInfo) {
		InfoSetter<FimgysarchInfo> attrSetter = new FimgysarchSetterGroup();
		return attrSetter.setAttr(recordInfo);
	}
}
