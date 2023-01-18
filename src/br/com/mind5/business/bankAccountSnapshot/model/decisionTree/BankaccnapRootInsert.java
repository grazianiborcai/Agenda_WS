package br.com.mind5.business.bankAccountSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.business.bankAccountSnapshot.model.action.BankaccnapVisiDaoInsert;
import br.com.mind5.business.bankAccountSnapshot.model.action.BankaccnapVisiRootSelect;
import br.com.mind5.business.bankAccountSnapshot.model.checker.BankaccnapCheckBankacc;
import br.com.mind5.business.bankAccountSnapshot.model.checker.BankaccnapCheckInsert;
import br.com.mind5.business.bankAccountSnapshot.model.checker.BankaccnapCheckLangu;
import br.com.mind5.business.bankAccountSnapshot.model.checker.BankaccnapCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class BankaccnapRootInsert extends DeciTreeTemplateWrite<BankaccnapInfo> {
	
	public BankaccnapRootInsert(DeciTreeOption<BankaccnapInfo> option) {
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
		checker = new BankaccnapCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BankaccnapCheckOwner(checkerOption);
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
		checker = new BankaccnapCheckBankacc(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BankaccnapInfo>> buildActionsOnPassedHook(DeciTreeOption<BankaccnapInfo> option) {
		List<ActionStd<BankaccnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<BankaccnapInfo> insert = new ActionStdCommom<BankaccnapInfo>(option, BankaccnapVisiDaoInsert.class);
		ActionLazy<BankaccnapInfo> select = new ActionLazyCommom<BankaccnapInfo>(option, BankaccnapVisiRootSelect.class);		
		
		insert.addPostAction(select);
		
		actions.add(insert);
		
		return actions;
	}
}
