package br.com.gda.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialMovement.model.action.StdMatmovSelect;
import br.com.gda.business.materialMovement.model.checker.MatmovCheckLangu;
import br.com.gda.business.materialMovement.model.checker.MatmovCheckRead;
import br.com.gda.business.materialMovement.model.checker.MatmovCheckStorauth;
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


public final class RootMatmovSelect implements DeciTree<MatmovInfo> {
	private DeciTree<MatmovInfo> tree;
	
	
	public RootMatmovSelect(DeciTreeOption<MatmovInfo> option) {
		DeciTreeHelperOption<MatmovInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatmovInfo> buildDecisionChecker(DeciTreeOption<MatmovInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatmovInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new MatmovCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatmovCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatmovCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatmovInfo>> buildActionsOnPassed(DeciTreeOption<MatmovInfo> option) {
		List<ActionStd<MatmovInfo>> actions = new ArrayList<>();

		ActionStd<MatmovInfo> select = new StdMatmovSelect(option);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatmovInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatmovInfo> toAction() {
		return tree.toAction();
	}
}
