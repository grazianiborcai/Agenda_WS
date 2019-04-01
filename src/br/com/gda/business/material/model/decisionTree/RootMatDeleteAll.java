package br.com.gda.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.action.LazyMatMergeToDelete;
import br.com.gda.business.material.model.action.LazyMatRootDelete;
import br.com.gda.business.material.model.action.StdMatEnforceOwnerKey;
import br.com.gda.business.material.model.checker.MatCheckDeleteAll;
import br.com.gda.business.material.model.checker.MatCheckHasItem;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatDeleteAll extends DeciTreeWriteTemplate<MatInfo> {
	
	public RootMatDeleteAll(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildDecisionCheckerHook(DeciTreeOption<MatInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checker = new MatCheckDeleteAll();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatCheckHasItem(checkerOption);
		queue.add(checker);	

		return new ModelCheckerQueue<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
		
		ActionStd<MatInfo> enforceOwnerKey = new StdMatEnforceOwnerKey(option);
		ActionLazy<MatInfo> mergeToDelete = new LazyMatMergeToDelete(option.conn, option.schemaName);
		ActionLazy<MatInfo> rootDelete = new LazyMatRootDelete(option.conn, option.schemaName);
		
		enforceOwnerKey.addPostAction(mergeToDelete);
		mergeToDelete.addPostAction(rootDelete);
		
		actions.add(enforceOwnerKey);
		return actions;
	}
}
