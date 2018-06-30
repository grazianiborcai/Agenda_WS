package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.checker.CusCheckCpf;
import br.com.gda.business.customer.model.checker.CusCheckExistCpf;
import br.com.gda.business.customer.model.checker.CusCheckExistEmail;
import br.com.gda.business.customer.model.checker.CusCheckGenField;
import br.com.gda.business.customer.model.checker.CusCheckOwner;
import br.com.gda.business.customer.model.checker.CusCheckWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCusInsert implements DeciTree<CusInfo> {
	private DeciTree<CusInfo> tree;
	
	
	public RootCusInsert(DeciTreeOption<CusInfo> option) {
		DeciTreeHelperOption<CusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CusInfo> buildDecisionChecker(DeciTreeOption<CusInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;	
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CusCheckWrite();
		queue.add(checker);
		
		checker = new CusCheckGenField();
		queue.add(checker);
		
		checker = new CusCheckCpf();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new CusCheckExistCpf(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new CusCheckExistEmail(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public DeciAction<CusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<DeciAction<CusInfo>> buildActionsOnPassed(DeciTreeOption<CusInfo> option) {
		List<DeciAction<CusInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionCusInsert(option));
		actions.add(new ActionCusSelect(option));		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
