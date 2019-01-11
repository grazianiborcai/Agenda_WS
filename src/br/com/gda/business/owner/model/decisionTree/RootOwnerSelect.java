package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerMergeAddress;
import br.com.gda.business.owner.model.action.LazyOwnerMergeComp;
import br.com.gda.business.owner.model.action.LazyOwnerMergePerson;
import br.com.gda.business.owner.model.action.LazyOwnerMergePersonUser;
import br.com.gda.business.owner.model.action.LazyOwnerMergePhone;
import br.com.gda.business.owner.model.action.StdOwnerSelect;
import br.com.gda.business.owner.model.checker.OwnerCheckRead;
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

public final class RootOwnerSelect implements DeciTree<OwnerInfo> {
	private DeciTree<OwnerInfo> tree;		
		
	public RootOwnerSelect(DeciTreeOption<OwnerInfo> option) {
		DeciTreeHelperOption<OwnerInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<OwnerInfo> buildDecisionChecker() {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		
		checker = new OwnerCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<OwnerInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<OwnerInfo>> buildActionsOnPassed(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> select = new StdOwnerSelect(option);
		ActionLazy<OwnerInfo> mergePerson = new LazyOwnerMergePerson(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> mergeComp = new LazyOwnerMergeComp(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> mergeAddress = new LazyOwnerMergeAddress(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> mergePhone = new LazyOwnerMergePhone(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> mergePersonUser = new LazyOwnerMergePersonUser(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeComp);
		mergeComp.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		//mergePhone.addPostAction(mergePersonUser);
		
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
	