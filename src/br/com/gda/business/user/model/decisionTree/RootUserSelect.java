package br.com.gda.business.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserMergeAddress;
import br.com.gda.business.user.model.action.LazyUserMergeAuthGrRole;
import br.com.gda.business.user.model.action.LazyUserMergePerson;
import br.com.gda.business.user.model.action.LazyUserMergePersonCus;
import br.com.gda.business.user.model.action.LazyUserMergePhone;
import br.com.gda.business.user.model.action.StdUserSelect;
import br.com.gda.business.user.model.checker.UserCheckRead;
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

public final class RootUserSelect implements DeciTree<UserInfo> {
	private DeciTree<UserInfo> tree;
	
	
	public RootUserSelect(DeciTreeOption<UserInfo> option) {
		DeciTreeHelperOption<UserInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UserInfo> buildDecisionChecker() {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		
		checker = new UserCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<UserInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<UserInfo>> buildActionsOnPassed(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> select = new StdUserSelect(option);
		ActionLazy<UserInfo> mergePerson = new LazyUserMergePerson(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeAddress = new LazyUserMergeAddress(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergePhone = new LazyUserMergePhone(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergePersonCus = new LazyUserMergePersonCus(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeAuthGrRole = new LazyUserMergeAuthGrRole(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergePersonCus);
		mergePersonCus.addPostAction(mergeAuthGrRole);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<UserInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
