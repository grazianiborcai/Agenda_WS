package br.com.mind5.business.bankAccount.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.info.BankaccMerger;
import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.business.bankAccountSnapshot.model.decisionTree.BankaccnapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiBankaccnapInsert extends ActionVisitorTemplateAction<BankaccInfo, BankaccnapInfo> {

	public BankaccVisiBankaccnapInsert(DeciTreeOption<BankaccInfo> option) {
		super(option, BankaccInfo.class, BankaccnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankaccnapInfo>> getTreeClassHook() {
		return BankaccnapRootInsert.class;
	}
	
	
	
	protected List<BankaccInfo> toBaseClassHook(List<BankaccInfo> baseInfos, List<BankaccnapInfo> selectedInfos) {
		return BankaccMerger.mergeWithBankaccnap(baseInfos, selectedInfos);
	}
}
