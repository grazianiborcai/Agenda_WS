package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.PayPartnerInfo;
import br.com.gda.business.masterData.model.action.StdPayPartnerSelect;
import br.com.gda.business.masterData.model.checker.PayPartnerCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootPayPartnerSelect implements DeciTree<PayPartnerInfo> {
	private DeciTree<PayPartnerInfo> tree;
	
	
	public RootPayPartnerSelect(DeciTreeOption<PayPartnerInfo> option) {
		DeciTreeHelperOption<PayPartnerInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayPartnerInfo> buildDecisionChecker() {
		List<ModelChecker<PayPartnerInfo>> queue = new ArrayList<>();		
		ModelChecker<PayPartnerInfo> checker;
		
		checker = new PayPartnerCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	private List<ActionStd<PayPartnerInfo>> buildActionsOnPassed(DeciTreeOption<PayPartnerInfo> option) {
		List<ActionStd<PayPartnerInfo>> actions = new ArrayList<>();
		
		actions.add(new StdPayPartnerSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PayPartnerInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PayPartnerInfo> toAction() {
		return tree.toAction();
	}
}
