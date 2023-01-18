package br.com.mind5.business.bankAccountSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.business.bankAccountSnapshot.model.decisionTree.BankaccnapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccnapVisiRootSelect extends ActionVisitorTemplateAction<BankaccnapInfo, BankaccnapInfo> {

	public BankaccnapVisiRootSelect(DeciTreeOption<BankaccnapInfo> option) {
		super(option, BankaccnapInfo.class, BankaccnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankaccnapInfo>> getTreeClassHook() {
		return BankaccnapRootSelect.class;
	}
	
	
	
	@Override protected List<BankaccnapInfo> toBaseClassHook(List<BankaccnapInfo> baseInfos, List<BankaccnapInfo> results) {
		return results;
	}
}
