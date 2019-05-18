package br.com.gda.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapInsertMatextsnap;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapRootSelect;
import br.com.gda.business.materialSnapshot.model.action.StdMatsnapInsert;
import br.com.gda.business.materialSnapshot.model.checker.MatsnapCheckOwner;
import br.com.gda.business.materialSnapshot.model.checker.MatsnapCheckWrite;
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

public final class RootMatsnapInsert implements DeciTree<MatsnapInfo> {
	private DeciTree<MatsnapInfo> tree;
	
	
	public RootMatsnapInsert(DeciTreeOption<MatsnapInfo> option) {
		DeciTreeHelperOption<MatsnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatsnapInfo> buildDecisionChecker(DeciTreeOption<MatsnapInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<MatsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatsnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new MatsnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new MatsnapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatsnapInfo>> buildActionsOnPassed(DeciTreeOption<MatsnapInfo> option) {
		List<ActionStd<MatsnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<MatsnapInfo> insert = new StdMatsnapInsert(option);
		ActionLazy<MatsnapInfo> insertMatextsnap = new LazyMatsnapInsertMatextsnap(option.conn, option.schemaName);	
		ActionLazy<MatsnapInfo> select = new LazyMatsnapRootSelect(option.conn, option.schemaName);	
		
		insert.addPostAction(insertMatextsnap);
		insertMatextsnap.addPostAction(select);
		
		actions.add(insert);
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
	
	
	
	@Override public ActionStd<MatsnapInfo> toAction() {
		return tree.toAction();
	}
}
