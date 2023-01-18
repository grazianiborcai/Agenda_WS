package br.com.mind5.business.bankAccount.model.action;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.info.BankaccSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiEnforceLChanged extends ActionVisitorTemplateEnforce<BankaccInfo> {
	
	public BankaccVisiEnforceLChanged(DeciTreeOption<BankaccInfo> option) {
		super(option);
	}
	
	
	
	@Override protected BankaccInfo enforceHook(BankaccInfo recordInfo) {
		InfoSetter<BankaccInfo> attrSetter = new BankaccSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
