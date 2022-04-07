package br.com.mind5.business.materialSearch.model.action;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.info.MatarchSetterSytotauhKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatarchVisiEnforceSytotauhKey extends ActionVisitorTemplateEnforce<MatarchInfo> {
	
	public MatarchVisiEnforceSytotauhKey(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatarchInfo enforceHook(MatarchInfo recordInfo) {
		InfoSetter<MatarchInfo> attrSetter = new MatarchSetterSytotauhKey();
		return attrSetter.setAttr(recordInfo);
	}
}
