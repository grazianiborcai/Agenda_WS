package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerEnforceAddressKey;
import br.com.gda.business.owner.model.action.LazyOwnerEnforceEntityCateg;
import br.com.gda.business.owner.model.action.LazyOwnerEnforcePhoneKey;
import br.com.gda.business.owner.model.action.LazyOwnerInsert;
import br.com.gda.business.owner.model.action.LazyOwnerInsertPerson;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpsertAddress;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpsertPhone;
import br.com.gda.business.owner.model.action.LazyOwnerRootSelect;
import br.com.gda.business.owner.model.action.StdOwnerEnforceLChanged;
import br.com.gda.business.owner.model.checker.OwnerCheckInsert;
import br.com.gda.business.owner.model.checker.OwnerCheckTechField;
import br.com.gda.business.owner.model.checker.OwnerCheckWriteAddress;
import br.com.gda.business.owner.model.checker.OwnerCheckWritePhone;
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

public final class RootOwnerInsert implements DeciTree<OwnerInfo> {
	private DeciTree<OwnerInfo> tree;
	
	
	public RootOwnerInsert(DeciTreeOption<OwnerInfo> option) {
		DeciTreeHelperOption<OwnerInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<OwnerInfo> buildDecisionChecker(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;	
		
		checker = new OwnerCheckInsert();
		queue.add(checker);
		
		checker = new OwnerCheckTechField();
		queue.add(checker);
		
		checker = new OwnerCheckWritePhone();
		queue.add(checker);
		
		checker = new OwnerCheckWriteAddress();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<OwnerInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<OwnerInfo>> buildActionsOnPassed(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforceLChanged = new StdOwnerEnforceLChanged(option);
		ActionLazy<OwnerInfo> enforceEntityCateg = new LazyOwnerEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertPerson = new LazyOwnerInsertPerson(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertCus = new LazyOwnerInsert(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> enforceAddressKey = new LazyOwnerEnforceAddressKey(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertAddress = new LazyOwnerNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> enforcePhoneKey = new LazyOwnerEnforcePhoneKey(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertPhone = new LazyOwnerNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<OwnerInfo> selectCustomer = new LazyOwnerRootSelect(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceEntityCateg);
		enforceEntityCateg.addPostAction(insertPerson);
		insertPerson.addPostAction(insertCus);		
		
		insertCus.addPostAction(enforceAddressKey);
		enforceAddressKey.addPostAction(upsertAddress);
		
		insertCus.addPostAction(enforcePhoneKey);
		enforcePhoneKey.addPostAction(upsertPhone);	
		
		insertCus.addPostAction(selectCustomer);
		
		actions.add(enforceLChanged);	
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
