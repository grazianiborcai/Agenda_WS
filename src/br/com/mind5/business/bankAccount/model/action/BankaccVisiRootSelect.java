package br.com.mind5.business.bankAccount.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.decisionTree.BankaccRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiRootSelect extends ActionVisitorTemplateAction<BankaccInfo, BankaccInfo> {

	public BankaccVisiRootSelect(DeciTreeOption<BankaccInfo> option) {
		super(option, BankaccInfo.class, BankaccInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankaccInfo>> getTreeClassHook() {
		return BankaccRootSelect.class;
	}
	
	
	
	@Override protected List<BankaccInfo> toBaseClassHook(List<BankaccInfo> baseInfos, List<BankaccInfo> results) {
		return results;
	}
}
