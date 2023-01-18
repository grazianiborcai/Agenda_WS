package br.com.mind5.business.bankAccountSearch.model.action;

import java.util.List;

import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.business.bankAccountSearch.model.decisionTree.BankaccarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccarchVisiRootSelect extends ActionVisitorTemplateAction<BankaccarchInfo, BankaccarchInfo> {

	public BankaccarchVisiRootSelect(DeciTreeOption<BankaccarchInfo> option) {
		super(option, BankaccarchInfo.class, BankaccarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankaccarchInfo>> getTreeClassHook() {
		return BankaccarchRootSelect.class;
	}
	
	
	
	@Override protected List<BankaccarchInfo> toBaseClassHook(List<BankaccarchInfo> baseInfos, List<BankaccarchInfo> results) {
		return results;
	}
}
