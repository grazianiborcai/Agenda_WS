package br.com.mind5.file.fileImageSearch.model.action;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchSetterEmp;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimarchEnforceEmp extends ActionVisitorTemplateEnforceV2<FimarchInfo> {
	
	public VisiFimarchEnforceEmp(DeciTreeOption<FimarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected FimarchInfo enforceHook(FimarchInfo recordInfo) {
		InfoSetter<FimarchInfo> attrSetter = new FimarchSetterEmp();
		return attrSetter.setAttr(recordInfo);
	}
}
