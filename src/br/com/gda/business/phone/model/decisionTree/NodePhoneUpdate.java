package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.LazyPhoneNodeUpdateT00;
import br.com.gda.business.phone.model.action.LazyPhoneNodeUpdateT01;
import br.com.gda.business.phone.model.action.StdPhoneEnforceNumberT00;
import br.com.gda.business.phone.model.action.StdPhoneEnforceNumberT01;
import br.com.gda.business.phone.model.checker.PhoneCheckFormT01;
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

public final class NodePhoneUpdate implements DeciTree<PhoneInfo> {
	private DeciTree<PhoneInfo> tree;
	
	
	public NodePhoneUpdate(DeciTreeOption<PhoneInfo> option) {
		DeciTreeHelperOption<PhoneInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PhoneInfo> buildDecisionChecker(DeciTreeOption<PhoneInfo> option) {
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	

		checker = new PhoneCheckFormT01();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PhoneInfo>> buildActionsOnPassed(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();
		//TODO: Verificar se chave referencia foi alterada
		ActionStd<PhoneInfo> enforceNumberT01 = new StdPhoneEnforceNumberT01(option);
		ActionLazy<PhoneInfo> nodeUpdateT01 = new LazyPhoneNodeUpdateT01(option.conn, option.schemaName);
		
		enforceNumberT01.addPostAction(nodeUpdateT01);

		actions.add(enforceNumberT01);		
		return actions;
	}
	
	
	
	private List<ActionStd<PhoneInfo>> buildActionsOnFailed(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();

		ActionStd<PhoneInfo> enforceNumberT00 = new StdPhoneEnforceNumberT00(option);
		ActionLazy<PhoneInfo> nodeUpdateT00 = new LazyPhoneNodeUpdateT00(option.conn, option.schemaName);
		
		enforceNumberT00.addPostAction(nodeUpdateT00);

		actions.add(enforceNumberT00);		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PhoneInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PhoneInfo> toAction() {
		return tree.toAction();
	}
}
