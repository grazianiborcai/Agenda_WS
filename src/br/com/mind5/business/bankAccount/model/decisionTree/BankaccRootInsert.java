package br.com.mind5.business.bankAccount.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiDaoInsert;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiEnforceCreatedBy;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiEnforceCreatedOn;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiEnforceLChanged;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiMergeUsername;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiNodeSnapshot;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiRootSelect;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckBank;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckBankacype;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckBankoldype;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckInsert;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckLangu;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckOwner;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class BankaccRootInsert extends DeciTreeTemplateWrite<BankaccInfo> {
	
	public BankaccRootInsert(DeciTreeOption<BankaccInfo> option) {
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
		checker = new BankaccCheckInsert(checkerOption);
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
		checker = new BankaccCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BankaccCheckBank(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BankaccCheckBankacype(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BankaccCheckBankoldype(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BankaccCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BankaccInfo>> buildActionsOnPassedHook(DeciTreeOption<BankaccInfo> option) {
		List<ActionStd<BankaccInfo>> actions = new ArrayList<>();		
		
		ActionStd<BankaccInfo> enforceLChanged = new ActionStdCommom<BankaccInfo>(option, BankaccVisiEnforceLChanged.class);	
		ActionLazy<BankaccInfo> enforceLChangedBy = new ActionLazyCommom<BankaccInfo>(option, BankaccVisiMergeUsername.class);		
		ActionLazy<BankaccInfo> enforceCreatedBy = new ActionLazyCommom<BankaccInfo>(option, BankaccVisiEnforceCreatedBy.class);	
		ActionLazy<BankaccInfo> enforceCreatedOn = new ActionLazyCommom<BankaccInfo>(option, BankaccVisiEnforceCreatedOn.class);
		ActionLazy<BankaccInfo> insert = new ActionLazyCommom<BankaccInfo>(option, BankaccVisiDaoInsert.class);
		ActionLazy<BankaccInfo> snapshot = new ActionLazyCommom<BankaccInfo>(option, BankaccVisiNodeSnapshot.class);
		ActionLazy<BankaccInfo> select = new ActionLazyCommom<BankaccInfo>(option, BankaccVisiRootSelect.class);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		insert.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);
		
		return actions;
	}
}
