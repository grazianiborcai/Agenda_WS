package br.com.mind5.business.bankAccount.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiMergeBank;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiMergeBankacype;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiMergeBankoldype;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiMergeToSelect;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckLangu;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckOwner;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BankaccRootSelect extends DeciTreeTemplateRead<BankaccInfo> {
	
	public BankaccRootSelect(DeciTreeOption<BankaccInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BankaccInfo> buildCheckerHook(DeciTreeOption<BankaccInfo> option) {
		List<ModelChecker<BankaccInfo>> queue = new ArrayList<>();		
		ModelChecker<BankaccInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BankaccCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BankaccCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BankaccCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BankaccInfo>> buildActionsOnPassedHook(DeciTreeOption<BankaccInfo> option) {
		List<ActionStd<BankaccInfo>> actions = new ArrayList<>();
		
		ActionStd<BankaccInfo> select = new ActionStdCommom<BankaccInfo>(option, BankaccVisiMergeToSelect.class);
		ActionLazy<BankaccInfo> mergeBankacype = new ActionLazyCommom<BankaccInfo>(option, BankaccVisiMergeBankacype.class);
		ActionLazy<BankaccInfo> mergeBankoldype = new ActionLazyCommom<BankaccInfo>(option, BankaccVisiMergeBankoldype.class);
		ActionLazy<BankaccInfo> mergeBank = new ActionLazyCommom<BankaccInfo>(option, BankaccVisiMergeBank.class);
		
		select.addPostAction(mergeBankacype);
		mergeBankacype.addPostAction(mergeBankoldype);
		mergeBankoldype.addPostAction(mergeBank);
		
		actions.add(select);
		return actions;
	}
}
