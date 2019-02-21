package br.com.gda.business.ownerStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.ownerStore.model.action.StdOwntoreSelect;
import br.com.gda.business.ownerStore.model.checker.OwntoreCheckLangu;
import br.com.gda.business.ownerStore.model.checker.OwntoreCheckRead;
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


public final class RootOwntoreSelect implements DeciTree<OwntoreInfo> {
	private DeciTree<OwntoreInfo> tree;
	
	
	public RootOwntoreSelect(DeciTreeOption<OwntoreInfo> option) {
		DeciTreeHelperOption<OwntoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<OwntoreInfo> buildDecisionChecker(DeciTreeOption<OwntoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OwntoreInfo>> queue = new ArrayList<>();		
		ModelChecker<OwntoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new OwntoreCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new OwntoreCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<OwntoreInfo>> buildActionsOnPassed(DeciTreeOption<OwntoreInfo> option) {
		List<ActionStd<OwntoreInfo>> actions = new ArrayList<>();

		ActionStd<OwntoreInfo> select = new StdOwntoreSelect(option);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<OwntoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<OwntoreInfo> toAction() {
		return tree.toAction();
	}
}
