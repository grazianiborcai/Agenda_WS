package br.com.mind5.business.bankAccount.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiMergeBankaccarchStore;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class BankaccRootSearchStore extends DeciTreeTemplateWrite<BankaccInfo> {
	
	public BankaccRootSearchStore(DeciTreeOption<BankaccInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BankaccInfo> buildCheckerHook(DeciTreeOption<BankaccInfo> option) {
		List<ModelChecker<BankaccInfo>> queue = new ArrayList<>();		
		ModelChecker<BankaccInfo> checker;
		
		checker = new ModelCheckerDummy<BankaccInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BankaccInfo>> buildActionsOnPassedHook(DeciTreeOption<BankaccInfo> option) {
		List<ActionStd<BankaccInfo>> actions = new ArrayList<>();
		
		ActionStd<BankaccInfo> searchStore = new ActionStdCommom<BankaccInfo>(option, BankaccVisiMergeBankaccarchStore.class);
		ActionLazy<BankaccInfo> select = new ActionLazyCommom<BankaccInfo>(option, BankaccVisiRootSelect.class);
		
		searchStore.addPostAction(select);
		
		actions.add(searchStore);
		return actions;
	}
}
