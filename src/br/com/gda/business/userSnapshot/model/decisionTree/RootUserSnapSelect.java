package br.com.gda.business.userSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.model.action.LazyUserSnapMergeAddressSnap;
import br.com.gda.business.userSnapshot.model.action.LazyUserSnapMergePersonCus;
import br.com.gda.business.userSnapshot.model.action.LazyUserSnapMergePersonSnap;
import br.com.gda.business.userSnapshot.model.action.LazyUserSnapMergePhoneSnap;
import br.com.gda.business.userSnapshot.model.action.StdUserSnapSelect;
import br.com.gda.business.userSnapshot.model.checker.UserSnapCheckRead;
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

public final class RootUserSnapSelect implements DeciTree<UserSnapInfo> {
	private DeciTree<UserSnapInfo> tree;
	
	
	public RootUserSnapSelect(DeciTreeOption<UserSnapInfo> option) {
		DeciTreeHelperOption<UserSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UserSnapInfo> buildDecisionChecker() {
		List<ModelChecker<UserSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<UserSnapInfo> checker;
		
		checker = new UserSnapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<UserSnapInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<UserSnapInfo>> buildActionsOnPassed(DeciTreeOption<UserSnapInfo> option) {
		List<ActionStd<UserSnapInfo>> actions = new ArrayList<>();
		
		ActionStd<UserSnapInfo> select = new StdUserSnapSelect(option);
		ActionLazy<UserSnapInfo> mergePerson = new LazyUserSnapMergePersonSnap(option.conn, option.schemaName);
		ActionLazy<UserSnapInfo> mergeAddress = new LazyUserSnapMergeAddressSnap(option.conn, option.schemaName);
		ActionLazy<UserSnapInfo> mergePhone = new LazyUserSnapMergePhoneSnap(option.conn, option.schemaName);
		//TODO: PersonCus nao vem do snapshot. Corrigir isso
		ActionLazy<UserSnapInfo> mergePersonCus = new LazyUserSnapMergePersonCus(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergePersonCus);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<UserSnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
