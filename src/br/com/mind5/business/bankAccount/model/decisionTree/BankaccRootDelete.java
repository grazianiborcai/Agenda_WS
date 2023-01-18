package br.com.mind5.business.bankAccount.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiDaoDelete;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiMergeToSelect;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckDelete;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckExist;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckLangu;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class BankaccRootDelete extends DeciTreeTemplateWrite<BankaccInfo> {
	
	public BankaccRootDelete(DeciTreeOption<BankaccInfo> option) {
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
		checker = new BankaccCheckDelete(checkerOption);
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
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BankaccCheckExist(checkerOption);
		queue.add(checker);		

		return new ModelCheckerHelperQueue<BankaccInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BankaccInfo>> buildActionsOnPassedHook(DeciTreeOption<BankaccInfo> option) {
		List<ActionStd<BankaccInfo>> actions = new ArrayList<>();
		
		ActionStd<BankaccInfo> select = new ActionStdCommom<BankaccInfo>(option, BankaccVisiMergeToSelect.class);
		ActionLazy<BankaccInfo> delete = new ActionLazyCommom<BankaccInfo>(option, BankaccVisiDaoDelete.class);
		
		select.addPostAction(delete);
		
		actions.add(select);
		return actions;
	}
}
