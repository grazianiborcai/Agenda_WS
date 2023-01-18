package br.com.mind5.business.bankAccountSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.business.bankAccountSearch.model.action.BankaccarchVisiEnforceStoreKey;
import br.com.mind5.business.bankAccountSearch.model.action.BankaccarchVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BankaccarchRootSelectStore extends DeciTreeTemplateRead<BankaccarchInfo> {
	
	public BankaccarchRootSelectStore(DeciTreeOption<BankaccarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BankaccarchInfo> buildCheckerHook(DeciTreeOption<BankaccarchInfo> option) {
		List<ModelChecker<BankaccarchInfo>> queue = new ArrayList<>();		
		ModelChecker<BankaccarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new ModelCheckerDummy<BankaccarchInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BankaccarchInfo>> buildActionsOnPassedHook(DeciTreeOption<BankaccarchInfo> option) {
		List<ActionStd<BankaccarchInfo>> actions = new ArrayList<>();
		
		ActionStd<BankaccarchInfo> enforceStoreKey = new ActionStdCommom<BankaccarchInfo>(option, BankaccarchVisiEnforceStoreKey.class);
		ActionLazy<BankaccarchInfo> select = new ActionLazyCommom<BankaccarchInfo>(option, BankaccarchVisiRootSelect.class);
		
		enforceStoreKey.addPostAction(select);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
