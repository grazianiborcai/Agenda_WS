package br.com.gda.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.action.LazyMatMergeMatCateg;
import br.com.gda.business.material.model.action.LazyMatMergeMatGroup;
import br.com.gda.business.material.model.action.LazyMatMergeMatType;
import br.com.gda.business.material.model.action.LazyMatMergeMatUnit;
import br.com.gda.business.material.model.action.StdMatSelect;
import br.com.gda.business.material.model.checker.MatCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatSelect implements DeciTree<MatInfo> {
	private DeciTree<MatInfo> tree;
	
	
	public RootMatSelect(DeciTreeOption<MatInfo> option) {
		DeciTreeHelperOption<MatInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatInfo> buildDecisionChecker() {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
		
		checker = new MatCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatInfo>> buildActionsOnPassed(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
		
		ActionStd<MatInfo> select = new StdMatSelect(option);
		ActionLazy<MatInfo> mergeMatType = new LazyMatMergeMatType(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatCateg = new LazyMatMergeMatCateg(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatGroup = new LazyMatMergeMatGroup(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatUnit = new LazyMatMergeMatUnit(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatType);
		mergeMatType.addPostAction(mergeMatCateg);
		mergeMatCateg.addPostAction(mergeMatGroup);
		mergeMatGroup.addPostAction(mergeMatUnit);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatInfo> toAction() {
		return tree.toAction();
	}
}
