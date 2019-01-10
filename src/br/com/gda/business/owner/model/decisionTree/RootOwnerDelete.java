package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.StdOwnerDelete;
import br.com.gda.business.owner.model.action.StdOwnerDeletePerson;
import br.com.gda.business.owner.model.checker.OwnerCheckExist;
import br.com.gda.business.owner.model.checker.OwnerCheckPersonChange;
import br.com.gda.business.owner.model.checker.OwnerCheckWrite;
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

public final class RootOwnerDelete implements DeciTree<OwnerInfo> {
	private DeciTree<OwnerInfo> tree;
	
	
	public RootOwnerDelete(DeciTreeOption<OwnerInfo> option) {
		DeciTreeHelperOption<OwnerInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<OwnerInfo> buildDecisionChecker(DeciTreeOption<OwnerInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean NOT_CHANGED = true;
		
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new OwnerCheckWrite();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new OwnerCheckExist(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = NOT_CHANGED;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new OwnerCheckPersonChange(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerQueue<OwnerInfo>(queue);
	}
	
	
	
	@Override public ActionStd<OwnerInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<OwnerInfo>> buildActionsOnPassed(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> deleteAddress = new NodeOwnerDeleteAddress(option).toAction();
		ActionStd<OwnerInfo> deletePhone = new NodeOwnerDeletePhone(option).toAction();
		ActionStd<OwnerInfo> deleteCustomer = new StdOwnerDelete(option);	
		ActionStd<OwnerInfo> deletePerson = new StdOwnerDeletePerson(option);
		
		actions.add(deleteAddress);
		actions.add(deletePhone);
		actions.add(deleteCustomer);
		actions.add(deletePerson);
		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
