package br.com.mind5.masterData.materialGroupSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchSetterBusinessKey;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatouparchVisiEnforceBusinessKey extends ActionVisitorTemplateEnforce<MatouparchInfo> {
	
	public MatouparchVisiEnforceBusinessKey(DeciTreeOption<MatouparchInfo> option) {
		super(option);
	}

	
	
	@Override protected MatouparchInfo enforceHook(MatouparchInfo recordInfo) {
		InfoSetter<MatouparchInfo> attrSetter = new MatouparchSetterBusinessKey();
		return attrSetter.setAttr(recordInfo);
	}
}
