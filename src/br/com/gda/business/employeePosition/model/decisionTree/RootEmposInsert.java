package br.com.gda.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.model.action.LazyEmposNodeInsert;
import br.com.gda.business.employeePosition.model.action.LazyEmposRootSelect;
import br.com.gda.business.employeePosition.model.action.StdEmposEnforceLChanged;
import br.com.gda.business.employeePosition.model.checker.EmposCheckEmp;
import br.com.gda.business.employeePosition.model.checker.EmposCheckPosition;
import br.com.gda.business.employeePosition.model.checker.EmposCheckExist;
import br.com.gda.business.employeePosition.model.checker.EmposCheckOwner;
import br.com.gda.business.employeePosition.model.checker.EmposCheckStore;
import br.com.gda.business.employeePosition.model.checker.EmposCheckWrite;
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

public final class RootEmposInsert implements DeciTree<EmposInfo> {
	private DeciTree<EmposInfo> tree;
	
	
	public RootEmposInsert(DeciTreeOption<EmposInfo> option) {
		DeciTreeHelperOption<EmposInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmposInfo> buildDecisionChecker(DeciTreeOption<EmposInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new EmposCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new EmposCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckPosition(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckEmp(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<EmposInfo>> buildActionsOnPassed(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> enforceLChanged = new StdEmposEnforceLChanged(option);
		ActionLazy<EmposInfo> nodeInsert = new LazyEmposNodeInsert(option.conn, option.schemaName);
		ActionLazy<EmposInfo> select = new LazyEmposRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(nodeInsert);
		nodeInsert.addPostAction(select);
		//actions.add(new NodeEmposInsertEWT(option).toAction());

		
		actions.add(enforceLChanged);
		return actions;
		
		//TODO: O InsertEWT pode gerar conflitos. Imagine que um empregado j� esteja lotado em uma outra loja.
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmposInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<EmposInfo> toAction() {
		return tree.toAction();
	}
}
