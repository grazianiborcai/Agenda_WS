package br.com.gda.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.action.LazyCompInsert;
import br.com.gda.business.company.model.action.StdCompEnforceLChanged;
import br.com.gda.business.company.model.checker.CompCheckCountry;
import br.com.gda.business.company.model.checker.CompCheckEntityCateg;
import br.com.gda.business.company.model.checker.CompCheckOwner;
import br.com.gda.business.company.model.checker.CompCheckTechField;
import br.com.gda.business.company.model.checker.CompCheckWrite;
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

public final class RootCompInsert implements DeciTree<CompInfo> {
	private DeciTree<CompInfo> tree;
	
	
	public RootCompInsert(DeciTreeOption<CompInfo> option) {
		DeciTreeHelperOption<CompInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CompInfo> buildDecisionChecker(DeciTreeOption<CompInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<CompInfo>> queue = new ArrayList<>();		
		ModelChecker<CompInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CompCheckWrite();
		queue.add(checker);
		
		checker = new CompCheckTechField();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CompCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CompCheckEntityCateg(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CompCheckCountry(checkerOption);
		queue.add(checker);	
			
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<CompInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<CompInfo>> buildActionsOnPassed(DeciTreeOption<CompInfo> option) {
		List<ActionStd<CompInfo>> actions = new ArrayList<>();
		
		ActionStd<CompInfo> nodeL1 = new NodeCompInsertL1(option).toAction();
		ActionStd<CompInfo> enforceLChanged = new StdCompEnforceLChanged(option);
		ActionLazy<CompInfo> insert = new LazyCompInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(insert);
		
		actions.add(nodeL1);
		actions.add(enforceLChanged);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CompInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
