package br.com.gda.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapMergeMatCateg;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapMergeMatGroup;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapMergeMatType;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapMergeMatUnit;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapMergeMatextsnap;
import br.com.gda.business.materialSnapshot.model.action.StdMatsnapSelect;
import br.com.gda.business.materialSnapshot.model.checker.MatsnapCheckRead;
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

public final class RootMatsnapSelect implements DeciTree<MatsnapInfo> {
	private DeciTree<MatsnapInfo> tree;
	
	
	public RootMatsnapSelect(DeciTreeOption<MatsnapInfo> option) {
		DeciTreeHelperOption<MatsnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatsnapInfo> buildDecisionChecker() {
		List<ModelChecker<MatsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatsnapInfo> checker;
		
		checker = new MatsnapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<MatsnapInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<MatsnapInfo>> buildActionsOnPassed(DeciTreeOption<MatsnapInfo> option) {
		List<ActionStd<MatsnapInfo>> actions = new ArrayList<>();
		
		ActionStd<MatsnapInfo> select = new StdMatsnapSelect(option);
		ActionLazy<MatsnapInfo> mergeMatextsnap = new LazyMatsnapMergeMatextsnap(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatType = new LazyMatsnapMergeMatType(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatCateg = new LazyMatsnapMergeMatCateg(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatGroup = new LazyMatsnapMergeMatGroup(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatUnit = new LazyMatsnapMergeMatUnit(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatextsnap);
		mergeMatextsnap.addPostAction(mergeMatType);
		mergeMatType.addPostAction(mergeMatCateg);
		mergeMatCateg.addPostAction(mergeMatGroup);
		mergeMatGroup.addPostAction(mergeMatUnit);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatsnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
