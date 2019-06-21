package br.com.gda.payment.payOrder.model.decisionTree;

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
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.action.LazyPayordMergePaypar;
import br.com.gda.payment.payOrder.model.action.StdPayordMergeToSelect;
import br.com.gda.payment.payOrder.model.checker.PayordCheckOwner;
import br.com.gda.payment.payOrder.model.checker.PayordCheckRead;
import br.com.gda.payment.payOrder.model.checker.PayordCheckStore;

public final class RootPayordSelect implements DeciTree<PayordInfo> {
	private DeciTree<PayordInfo> tree;
	
	
	public RootPayordSelect(DeciTreeOption<PayordInfo> option) {
		DeciTreeHelperOption<PayordInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayordInfo> buildDecisionChecker(DeciTreeOption<PayordInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new PayordCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayordCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayordCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PayordInfo>> buildActionsOnPassed(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordInfo> select = new StdPayordMergeToSelect(option);
		ActionLazy<PayordInfo> mergePayPartner = new LazyPayordMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PayordInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PayordInfo> toAction() {
		return tree.toAction();
	}
}
