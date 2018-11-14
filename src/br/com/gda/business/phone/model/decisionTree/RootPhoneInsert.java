package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.LazyPhoneEnforceLChanged;
import br.com.gda.business.phone.model.action.LazymapPhoneNodeInsert;
import br.com.gda.business.phone.model.action.MapPhoneMergeForm;
import br.com.gda.business.phone.model.checker.PhoneCheckCountry;
import br.com.gda.business.phone.model.checker.PhoneCheckLimit;
import br.com.gda.business.phone.model.checker.PhoneCheckRef;
import br.com.gda.business.phone.model.checker.PhoneCheckRefMulti;
import br.com.gda.business.phone.model.checker.PhoneCheckWrite;
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

public final class RootPhoneInsert implements DeciTree<PhoneInfo> {
	private DeciTree<PhoneInfo> tree;
	
	
	public RootPhoneInsert(DeciTreeOption<PhoneInfo> option) {
		DeciTreeHelperOption<PhoneInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PhoneInfo> buildDecisionChecker(DeciTreeOption<PhoneInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PhoneCheckWrite();
		queue.add(checker);
		
		checker = new PhoneCheckRef();
		queue.add(checker);
		
		checker = new PhoneCheckRefMulti();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new PhoneCheckCountry(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checker = new PhoneCheckLimit(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PhoneInfo>> buildActionsOnPassed(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();	
		
		ActionStd<PhoneInfo> mergeForm = new MapPhoneMergeForm(option);		
		ActionLazy<PhoneInfo> enforceLChanged = new LazyPhoneEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> nodeInsert = new LazymapPhoneNodeInsert(option.conn, option.schemaName);	
		
		mergeForm.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(nodeInsert);
		
		actions.add(mergeForm);		
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
