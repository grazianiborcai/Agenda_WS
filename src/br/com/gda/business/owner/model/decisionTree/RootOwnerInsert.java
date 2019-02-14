package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerEnforceAuthGroup;
import br.com.gda.business.owner.model.action.LazyOwnerEnforceCompKey;
import br.com.gda.business.owner.model.action.LazyOwnerEnforceEntityCateg;
import br.com.gda.business.owner.model.action.LazyOwnerEnforcePersonKey;
import br.com.gda.business.owner.model.action.LazyOwnerInsert;
import br.com.gda.business.owner.model.action.LazyOwnerInsertComp;
import br.com.gda.business.owner.model.action.LazyOwnerInsertPerson;
import br.com.gda.business.owner.model.action.LazyOwnerInsertUser;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpsertAddress;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpsertPhone;
import br.com.gda.business.owner.model.action.LazyOwnerRootSelect;
import br.com.gda.business.owner.model.action.LazyOwnerUpdate;
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
		ActionLazy<OwnerInfo> insertOwner = new LazyOwnerInsert(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> enforceEntityCateg = new LazyOwnerEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> enforceAuthGroup = new LazyOwnerEnforceAuthGroup(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> enforcePersonKey = new LazyOwnerEnforcePersonKey(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertPerson = new LazyOwnerInsertPerson(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> enforceCompKey = new LazyOwnerEnforceCompKey(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertComp = new LazyOwnerInsertComp(option.conn, option.schemaName);		
		ActionLazy<OwnerInfo> insertUser = new LazyOwnerInsertUser(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> updateOwner = new LazyOwnerUpdate(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertAddress = new LazyOwnerNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertPhone = new LazyOwnerNodeUpsertPhone(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> select = new LazyOwnerRootSelect(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(insertOwner);
		
		insertOwner.addPostAction(enforceEntityCateg);		
		enforceEntityCateg.addPostAction(enforceAuthGroup);
		enforceAuthGroup.addPostAction(enforcePersonKey);
		enforcePersonKey.addPostAction(insertPerson);
		
		insertPerson.addPostAction(enforceCompKey);
		enforceCompKey.addPostAction(insertComp);	
		
		insertComp.addPostAction(insertUser);		
		
		insertUser.addPostAction(updateOwner);		
		insertUser.addPostAction(upsertAddress);		
		insertUser.addPostAction(upsertPhone);			
		insertUser.addPostAction(select);
		
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
