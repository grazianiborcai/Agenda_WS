package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.LazyStoreMergeAddress;
import br.com.gda.business.store.model.action.LazyStoreMergeComp;
import br.com.gda.business.store.model.action.LazyStoreMergeCurrency;
import br.com.gda.business.store.model.action.LazyStoreMergePerson;
import br.com.gda.business.store.model.action.LazyStoreMergePhone;
import br.com.gda.business.store.model.action.LazyStoreMergeTimezone;
import br.com.gda.business.store.model.action.LazyStoreMergeUser;
import br.com.gda.business.store.model.action.StdStoreSelect;
import br.com.gda.business.store.model.checker.StoreCheckLangu;
import br.com.gda.business.store.model.checker.StoreCheckRead;
import br.com.gda.business.store.model.checker.StoreCheckStorauth;
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


public final class RootStoreSelect implements DeciTree<StoreInfo> {
	private DeciTree<StoreInfo> tree;
	
	
	public RootStoreSelect(DeciTreeOption<StoreInfo> option) {
		DeciTreeHelperOption<StoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreInfo> buildDecisionChecker(DeciTreeOption<StoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new StoreCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreCheckStorauth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<StoreInfo>> buildActionsOnPassed(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();

		ActionStd<StoreInfo> select = new StdStoreSelect(option);
		ActionLazy<StoreInfo> mergeCurrency = new LazyStoreMergeCurrency(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergeTimezone = new LazyStoreMergeTimezone(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergePerson = new LazyStoreMergePerson(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergeComp = new LazyStoreMergeComp(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergeAddress = new LazyStoreMergeAddress(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergePhone = new LazyStoreMergePhone(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergeUser = new LazyStoreMergeUser(option.conn, option.schemaName);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeTimezone);
		mergeTimezone.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeComp);
		mergeComp.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeUser);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<StoreInfo> toAction() {
		return tree.toAction();
	}
}
