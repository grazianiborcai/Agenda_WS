package br.com.gda.payment.ownerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

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
import br.com.gda.payment.ownerPartner.info.OwnparInfo;
import br.com.gda.payment.ownerPartner.model.action.LazyOwnparNodeSelectL1;
import br.com.gda.payment.ownerPartner.model.action.StdOwnparMergeOwner;
import br.com.gda.payment.ownerPartner.model.checker.OwnparCheckOwner;
import br.com.gda.payment.ownerPartner.model.checker.OwnparCheckRead;

public final class RootOwnparSelect implements DeciTree<OwnparInfo> {
	private DeciTree<OwnparInfo> tree;
	
	
	public RootOwnparSelect(DeciTreeOption<OwnparInfo> option) {
		DeciTreeHelperOption<OwnparInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<OwnparInfo> buildDecisionChecker(DeciTreeOption<OwnparInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OwnparInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new OwnparCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new OwnparCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<OwnparInfo>> buildActionsOnPassed(DeciTreeOption<OwnparInfo> option) {
		List<ActionStd<OwnparInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnparInfo> mergeOwner = new StdOwnparMergeOwner(option);
		ActionLazy<OwnparInfo> nodeSelectL1 = new LazyOwnparNodeSelectL1(option.conn, option.schemaName);
		
		mergeOwner.addPostAction(nodeSelectL1);
		
		actions.add(mergeOwner);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<OwnparInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<OwnparInfo> toAction() {
		return tree.toAction();
	}
}
