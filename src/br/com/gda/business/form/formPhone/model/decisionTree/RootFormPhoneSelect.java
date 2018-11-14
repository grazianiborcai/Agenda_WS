package br.com.gda.business.form.formPhone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.form.formPhone.model.checker.FormPhoneCheckCountry;
import br.com.gda.business.form.formPhone.model.checker.FormPhoneCheckRead;
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

public final class RootFormPhoneSelect implements DeciTree<FormPhoneInfo> {
	private DeciTree<FormPhoneInfo> tree;
	
	
	public RootFormPhoneSelect(DeciTreeOption<FormPhoneInfo> option) {
		DeciTreeHelperOption<FormPhoneInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<FormPhoneInfo> buildDecisionChecker(DeciTreeOption<FormPhoneInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<FormPhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<FormPhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new FormPhoneCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new FormPhoneCheckCountry(checkerOption);
		queue.add(checker);
		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<FormPhoneInfo>> buildActionsOnPassed(DeciTreeOption<FormPhoneInfo> option) {
		List<ActionStd<FormPhoneInfo>> actions = new ArrayList<>();
		
		actions.add(new NodeFormPhoneSelect(option).toAction());
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<FormPhoneInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<FormPhoneInfo> toAction() {
		return tree.toAction();
	}
}
