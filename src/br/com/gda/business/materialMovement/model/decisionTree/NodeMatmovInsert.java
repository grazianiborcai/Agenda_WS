package br.com.gda.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialMovement.model.action.LazyMatmovRootSelect;
import br.com.gda.business.materialMovement.model.action.LazyMatmovUpsertMatock;
import br.com.gda.business.materialMovement.model.action.StdMatmovInsert;
import br.com.gda.business.materialMovement.model.checker.MatmovCheckProduct;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeMatmovInsert implements DeciTree<MatmovInfo> {
	private DeciTree<MatmovInfo> tree;
	
	
	public NodeMatmovInsert(DeciTreeOption<MatmovInfo> option) {
		DeciTreeHelperOption<MatmovInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatmovInfo> buildDecisionChecker(DeciTreeOption<MatmovInfo> option) {
		List<ModelChecker<MatmovInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovInfo> checker;	
		
		checker = new MatmovCheckProduct();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatmovInfo>> buildActionsOnPassed(DeciTreeOption<MatmovInfo> option) {
		List<ActionStd<MatmovInfo>> actions = new ArrayList<>();

		ActionStd<MatmovInfo> insert = new StdMatmovInsert(option);
		ActionLazy<MatmovInfo> upsertStock = new LazyMatmovUpsertMatock(option.conn, option.schemaName);
		ActionLazy<MatmovInfo> select = new LazyMatmovRootSelect(option.conn, option.schemaName);	
		
		insert.addPostAction(upsertStock);
		insert.addPostAction(select);
		
		actions.add(insert);	
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
