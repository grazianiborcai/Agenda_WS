package br.com.gda.payment.storePartnerSnapshot.model.decisionTree;

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
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.gda.payment.storePartnerSnapshot.model.action.LazyStoparnapMergePaypar;
import br.com.gda.payment.storePartnerSnapshot.model.action.StdStoparnapMergeToSelect;
import br.com.gda.payment.storePartnerSnapshot.model.checker.StoparnapCheckOwner;
import br.com.gda.payment.storePartnerSnapshot.model.checker.StoparnapCheckRead;

public final class RootStoparnapSelect implements DeciTree<StoparnapInfo> {
	private DeciTree<StoparnapInfo> tree;
	
	
	public RootStoparnapSelect(DeciTreeOption<StoparnapInfo> option) {
		DeciTreeHelperOption<StoparnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoparnapInfo> buildDecisionChecker(DeciTreeOption<StoparnapInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StoparnapInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new StoparnapCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoparnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<StoparnapInfo>> buildActionsOnPassed(DeciTreeOption<StoparnapInfo> option) {
		List<ActionStd<StoparnapInfo>> actions = new ArrayList<>();
		
		ActionStd<StoparnapInfo> select = new StdStoparnapMergeToSelect(option);
		ActionLazy<StoparnapInfo> mergePayPartner = new LazyStoparnapMergePaypar(option.conn, option.schemaName);
		
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
	
	
	
	@Override public DeciResult<StoparnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<StoparnapInfo> toAction() {
		return tree.toAction();
	}
}
