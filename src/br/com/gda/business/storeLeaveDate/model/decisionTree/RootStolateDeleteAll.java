package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateMergeToDelete;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateRootDelete;
import br.com.gda.business.storeLeaveDate.model.action.StdStolateEnforceStoreKey;
import br.com.gda.business.storeLeaveDate.model.checker.StolateCheckDeleteAll;
import br.com.gda.business.storeLeaveDate.model.checker.StolateCheckHasItem;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootStolateDeleteAll extends DeciTreeWriteTemplate<StolateInfo> {
	
	public RootStolateDeleteAll(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolateInfo> buildDecisionCheckerHook(DeciTreeOption<StolateInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StolateInfo>> queue = new ArrayList<>();		
		ModelChecker<StolateInfo> checker;
		ModelCheckerOption checkerOption;
			
		checker = new StolateCheckDeleteAll();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StolateCheckHasItem(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<StolateInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStd<StolateInfo>> actions = new ArrayList<>();
		
		ActionStd<StolateInfo> enforceStoreKey = new StdStolateEnforceStoreKey(option);
		ActionLazy<StolateInfo> mergeToDelete = new LazyStolateMergeToDelete(option.conn, option.schemaName);
		ActionLazy<StolateInfo> delete = new LazyStolateRootDelete(option.conn, option.schemaName);
		
		enforceStoreKey.addPostAction(mergeToDelete);
		mergeToDelete.addPostAction(delete);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
