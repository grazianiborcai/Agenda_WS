package br.com.gda.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.action.LazyMatextMergeUsername;
import br.com.gda.business.materialText.model.action.LazyMatextNodeHasDefault;
import br.com.gda.business.materialText.model.action.LazyMatextNodeInsert;
import br.com.gda.business.materialText.model.action.StdMatextEnforceLChanged;
import br.com.gda.business.materialText.model.checker.MatextCheckExist;
import br.com.gda.business.materialText.model.checker.MatextCheckLangu;
import br.com.gda.business.materialText.model.checker.MatextCheckMat;
import br.com.gda.business.materialText.model.checker.MatextCheckOwner;
import br.com.gda.business.materialText.model.checker.MatextCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatextInsert implements DeciTree<MatextInfo> {
	private DeciTree<MatextInfo> tree;
	
	
	public RootMatextInsert(DeciTreeOption<MatextInfo> option) {
		DeciTreeHelperOption<MatextInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatextInfo> buildDecisionChecker(DeciTreeOption<MatextInfo> option) {
		final boolean EXIST_ON_DB = true;
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new MatextCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatextCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatextCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatextCheckMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;	
		checker = new MatextCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatextInfo>> buildActionsOnPassed(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatextInfo> nodeDefaultOn = new NodeMatextDefaultOn(option).toAction();	
		ActionStd<MatextInfo> enforceLChanged = new StdMatextEnforceLChanged(option);	
		ActionLazy<MatextInfo> enforceLChangedBy = new LazyMatextMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatextInfo> insert = new LazyMatextNodeInsert(option.conn, option.schemaName);	
		ActionLazy<MatextInfo> nodeHasDefault = new LazyMatextNodeHasDefault(option.conn, option.schemaName);
		ActionStd<MatextInfo> select = new RootMatextSelect(option).toAction();		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(insert);
		insert.addPostAction(nodeHasDefault);
		
		actions.add(nodeDefaultOn);
		actions.add(enforceLChanged);
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatextInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatextInfo> toAction() {
		return tree.toAction();
	}
}
