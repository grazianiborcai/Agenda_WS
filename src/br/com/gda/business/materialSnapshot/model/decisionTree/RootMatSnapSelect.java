package br.com.gda.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.model.action.LazyMatSnapMergeCurrency;
import br.com.gda.business.materialSnapshot.model.action.LazyMatSnapMergeMatCateg;
import br.com.gda.business.materialSnapshot.model.action.LazyMatSnapMergeMatGroup;
import br.com.gda.business.materialSnapshot.model.action.LazyMatSnapMergeMatType;
import br.com.gda.business.materialSnapshot.model.action.LazyMatSnapMergeMatUnit;
import br.com.gda.business.materialSnapshot.model.action.StdMatSnapSelect;
import br.com.gda.business.materialSnapshot.model.checker.MatSnapCheckRead;
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

public final class RootMatSnapSelect implements DeciTree<MatSnapInfo> {
	private DeciTree<MatSnapInfo> tree;
	
	
	public RootMatSnapSelect(DeciTreeOption<MatSnapInfo> option) {
		DeciTreeHelperOption<MatSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatSnapInfo> buildDecisionChecker() {
		List<ModelChecker<MatSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatSnapInfo> checker;
		
		checker = new MatSnapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<MatSnapInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<MatSnapInfo>> buildActionsOnPassed(DeciTreeOption<MatSnapInfo> option) {
		List<ActionStd<MatSnapInfo>> actions = new ArrayList<>();
		
		ActionStd<MatSnapInfo> select = new StdMatSnapSelect(option);
		ActionLazy<MatSnapInfo> mergeMatType = new LazyMatSnapMergeMatType(option.conn, option.schemaName);
		ActionLazy<MatSnapInfo> mergeMatCateg = new LazyMatSnapMergeMatCateg(option.conn, option.schemaName);
		ActionLazy<MatSnapInfo> mergeMatGroup = new LazyMatSnapMergeMatGroup(option.conn, option.schemaName);
		ActionLazy<MatSnapInfo> mergeCurrency = new LazyMatSnapMergeCurrency(option.conn, option.schemaName);
		ActionLazy<MatSnapInfo> mergeMatUnit = new LazyMatSnapMergeMatUnit(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatType);
		mergeMatType.addPostAction(mergeMatCateg);
		mergeMatCateg.addPostAction(mergeMatGroup);
		mergeMatGroup.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeMatUnit);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatSnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
