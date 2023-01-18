package br.com.mind5.business.bankAccountSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.business.bankAccountSnapshot.model.action.BankaccnapVisiMergeBank;
import br.com.mind5.business.bankAccountSnapshot.model.action.BankaccnapVisiMergeBankacype;
import br.com.mind5.business.bankAccountSnapshot.model.action.BankaccnapVisiMergeBankoldype;
import br.com.mind5.business.bankAccountSnapshot.model.action.BankaccnapVisiMergeToSelect;
import br.com.mind5.business.bankAccountSnapshot.model.checker.BankaccnapCheckLangu;
import br.com.mind5.business.bankAccountSnapshot.model.checker.BankaccnapCheckOwner;
import br.com.mind5.business.bankAccountSnapshot.model.checker.BankaccnapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BankaccnapRootSelect extends DeciTreeTemplateRead<BankaccnapInfo> {
	
	public BankaccnapRootSelect(DeciTreeOption<BankaccnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BankaccnapInfo> buildCheckerHook(DeciTreeOption<BankaccnapInfo> option) {
		List<ModelChecker<BankaccnapInfo>> queue = new ArrayList<>();		
		ModelChecker<BankaccnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BankaccnapCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BankaccnapCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BankaccnapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BankaccnapInfo>> buildActionsOnPassedHook(DeciTreeOption<BankaccnapInfo> option) {
		List<ActionStd<BankaccnapInfo>> actions = new ArrayList<>();
		
		ActionStd<BankaccnapInfo> select = new ActionStdCommom<BankaccnapInfo>(option, BankaccnapVisiMergeToSelect.class);
		ActionLazy<BankaccnapInfo> mergeBankacype = new ActionLazyCommom<BankaccnapInfo>(option, BankaccnapVisiMergeBankacype.class);
		ActionLazy<BankaccnapInfo> mergeBankoldype = new ActionLazyCommom<BankaccnapInfo>(option, BankaccnapVisiMergeBankoldype.class);
		ActionLazy<BankaccnapInfo> mergeBank = new ActionLazyCommom<BankaccnapInfo>(option, BankaccnapVisiMergeBank.class);
		
		select.addPostAction(mergeBankacype);
		mergeBankacype.addPostAction(mergeBankoldype);
		mergeBankoldype.addPostAction(mergeBank);
		
		actions.add(select);
		return actions;
	}
}
