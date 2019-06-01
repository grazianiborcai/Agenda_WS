package br.com.gda.business.userSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.business.userSnapshot.model.action.LazyUserapMergeAddresnap;
import br.com.gda.business.userSnapshot.model.action.LazyUserapMergePersonap;
import br.com.gda.business.userSnapshot.model.action.LazyUserapMergePhonap;
import br.com.gda.business.userSnapshot.model.action.StdUserapMergeToSelect;
import br.com.gda.business.userSnapshot.model.checker.UserapCheckRead;
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

public final class RootUserapSelect implements DeciTree<UserapInfo> {
	private DeciTree<UserapInfo> tree;
	
	
	public RootUserapSelect(DeciTreeOption<UserapInfo> option) {
		DeciTreeHelperOption<UserapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UserapInfo> buildDecisionChecker() {
		List<ModelChecker<UserapInfo>> queue = new ArrayList<>();		
		ModelChecker<UserapInfo> checker;
		
		checker = new UserapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<UserapInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<UserapInfo>> buildActionsOnPassed(DeciTreeOption<UserapInfo> option) {
		List<ActionStd<UserapInfo>> actions = new ArrayList<>();
		
		ActionStd<UserapInfo> select = new StdUserapMergeToSelect(option);
		ActionLazy<UserapInfo> mergePerson = new LazyUserapMergePersonap(option.conn, option.schemaName);
		ActionLazy<UserapInfo> mergeAddress = new LazyUserapMergeAddresnap(option.conn, option.schemaName);
		ActionLazy<UserapInfo> mergePhone = new LazyUserapMergePhonap(option.conn, option.schemaName);
		//TODO: PersonCus nao vem do snapshot. Corrigir isso
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<UserapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
