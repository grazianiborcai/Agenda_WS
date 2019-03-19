package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.action.StdMatoreSelect;
import br.com.gda.business.materialStore.model.action.LazyMatoreMergeMat;
import br.com.gda.business.materialStore.model.checker.MatoreCheckRead;
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

public final class RootMatoreSelect implements DeciTree<MatoreInfo> {
	private DeciTree<MatoreInfo> tree;
	
	
	public RootMatoreSelect(DeciTreeOption<MatoreInfo> option) {
		DeciTreeHelperOption<MatoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatoreInfo> buildDecisionChecker() {
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		
		checker = new MatoreCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatoreInfo>> buildActionsOnPassed(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoreInfo> select = new StdMatoreSelect(option);
		ActionLazy<MatoreInfo> mergeMat = new LazyMatoreMergeMat(option.conn, option.schemaName);		
		
		select.addPostAction(mergeMat);		
		actions.add(select);
		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatoreInfo> toAction() {
		return tree.toAction();
	}
}
