package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatmovTypeInfo;
import br.com.gda.business.masterData.model.action.StdMatmovTypeSelect;
import br.com.gda.business.masterData.model.checker.MatmovTypeCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatmovTypeSelect implements DeciTree<MatmovTypeInfo> {
	private DeciTree<MatmovTypeInfo> tree;
	
	
	public RootMatmovTypeSelect(DeciTreeOption<MatmovTypeInfo> option) {
		DeciTreeHelperOption<MatmovTypeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatmovTypeInfo> buildDecisionChecker() {
		List<ModelChecker<MatmovTypeInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovTypeInfo> checker;
		
		checker = new MatmovTypeCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	private List<ActionStd<MatmovTypeInfo>> buildActionsOnPassed(DeciTreeOption<MatmovTypeInfo> option) {
		List<ActionStd<MatmovTypeInfo>> actions = new ArrayList<>();
		
		actions.add(new StdMatmovTypeSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatmovTypeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatmovTypeInfo> toAction() {
		return tree.toAction();
	}
}
