package br.com.mind5.business.bankAccount.model.action;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.info.BankaccSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<BankaccInfo> {
	
	public BankaccVisiEnforceCreatedBy(DeciTreeOption<BankaccInfo> option) {
		super(option);
	}
	
	
	
	@Override protected BankaccInfo enforceHook(BankaccInfo recordInfo) {
		InfoSetter<BankaccInfo> attrSetter = new BankaccSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
