package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmDelete;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmEnforceLChanged;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmMergeUsername;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmUpdate;
import br.com.gda.business.storeWorkTime.model.action.StdStowotmMergeToDelete;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckExist;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckDelete;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckStorauth;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootStowotmDelete implements DeciTree<StowotmInfo> {
	private DeciTree<StowotmInfo> tree;
	
	
	public RootStowotmDelete(DeciTreeOption<StowotmInfo> option) {
		DeciTreeHelperOption<StowotmInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StowotmInfo> buildDecisionChecker(DeciTreeOption<StowotmInfo> option) {
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;
		ModelCheckerOption checkerOption;
			
		checker = new StowotmCheckDelete();
		queue.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StowotmCheckExist(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StowotmCheckStorauth(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerQueue<StowotmInfo>(queue);
	}
	
	
	
	private List<ActionStd<StowotmInfo>> buildActionsOnPassed(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> mergeToDelete = new StdStowotmMergeToDelete(option);
		ActionLazy<StowotmInfo> enforceLChanged = new LazyStowotmEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> enforceLChangedBy = new LazyStowotmMergeUsername(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> update = new LazyStowotmUpdate(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> delete = new LazyStowotmDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StowotmInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<StowotmInfo> toAction() {
		return tree.toAction();
	}
}
