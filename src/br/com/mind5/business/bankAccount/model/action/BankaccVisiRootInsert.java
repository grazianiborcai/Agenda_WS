package br.com.mind5.business.bankAccount.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.decisionTree.BankaccRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiRootInsert extends ActionVisitorTemplateAction<BankaccInfo, BankaccInfo> {

	public BankaccVisiRootInsert(DeciTreeOption<BankaccInfo> option) {
		super(option, BankaccInfo.class, BankaccInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankaccInfo>> getTreeClassHook() {
		return BankaccRootInsert.class;
	}
	
	
	
	@Override protected List<BankaccInfo> toBaseClassHook(List<BankaccInfo> baseInfos, List<BankaccInfo> results) {
		return results;
	}
}
