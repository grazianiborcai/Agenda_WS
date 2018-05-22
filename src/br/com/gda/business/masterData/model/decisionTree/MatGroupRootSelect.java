package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.model.checker.MatGroupCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatGroupRootSelect implements DeciTree<MatGroupInfo> {
	private DeciTree<MatGroupInfo> tree;
	
	
	public MatGroupRootSelect(DeciTreeOption<MatGroupInfo> option) {
		DeciTreeHelperOption<MatGroupInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatGroupInfo> buildDecisionChecker() {
		List<ModelChecker<MatGroupInfo>> stack = new ArrayList<>();		
		ModelChecker<MatGroupInfo> checker;
		
		checker = new MatGroupCheckRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<MatGroupInfo>> buildActionsOnPassed(DeciTreeOption<MatGroupInfo> option) {
		List<DeciAction<MatGroupInfo>> actions = new ArrayList<>();
		
		actions.add(new MatGroupActionSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatGroupInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
