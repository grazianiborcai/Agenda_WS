package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerDelete;
import br.com.gda.business.owner.model.action.LazyOwnerDeleteComp;
import br.com.gda.business.owner.model.action.LazyOwnerDeletePerson;
import br.com.gda.business.owner.model.action.LazyOwnerDeleteUser;
import br.com.gda.business.owner.model.action.LazyOwnerNodeDeleteAddress;
import br.com.gda.business.owner.model.action.LazyOwnerNodeDeletePhone;
import br.com.gda.business.owner.model.checker.OwnerCheckDelete;
import br.com.gda.business.owner.model.checker.OwnerCheckExist;
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
		
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new OwnerCheckDelete();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new OwnerCheckExist(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<OwnerInfo>(queue);
	}
	
	
	
	@Override public ActionStd<OwnerInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<OwnerInfo>> buildActionsOnPassed(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> select = new RootOwnerSelect(option).toAction();
		ActionLazy<OwnerInfo> deleteAddress = new LazyOwnerNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deletePhone = new LazyOwnerNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deletePerson = new LazyOwnerDeletePerson(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deleteCompany = new LazyOwnerDeleteComp(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deleteUser = new LazyOwnerDeleteUser(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deleteOwner = new LazyOwnerDelete(option.conn, option.schemaName);			
		
		select.addPostAction(deleteAddress);
		select.addPostAction(deletePhone);
		select.addPostAction(deletePerson);
		select.addPostAction(deleteCompany);
		select.addPostAction(deleteUser);
		select.addPostAction(deleteOwner);
		
		actions.add(select);
		
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
