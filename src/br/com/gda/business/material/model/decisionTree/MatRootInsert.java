package br.com.gda.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.checker.MatCheckCateg;
import br.com.gda.business.material.model.checker.MatCheckCurrency;
import br.com.gda.business.material.model.checker.MatCheckGenField;
import br.com.gda.business.material.model.checker.MatCheckGroup;
import br.com.gda.business.material.model.checker.MatCheckLangu;
import br.com.gda.business.material.model.checker.MatCheckType;
import br.com.gda.business.material.model.checker.MatCheckUnit;
import br.com.gda.business.material.model.checker.MatCheckWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatRootInsert implements DeciTree<MatInfo> {
	private DeciTree<MatInfo> tree;
	
	
	public MatRootInsert(DeciTreeOption<MatInfo> option) {
		DeciTreeHelperOption<MatInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatInfo> buildDecisionChecker(DeciTreeOption<MatInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatInfo>> stack = new ArrayList<>();		
		ModelChecker<MatInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new MatCheckWrite();
		stack.add(checker);
		
		checker = new MatCheckGenField();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckLangu(checkerOption);
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckCurrency(checkerOption);
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckUnit(checkerOption);
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckCateg(checkerOption);
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckGroup(checkerOption);
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckType(checkerOption);
		stack.add(checker);
		
		//TODO: verificar se barcode ou código do fornecedor já existe  no banco
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<MatInfo>> buildActionsOnPassed(DeciTreeOption<MatInfo> option) {
		List<DeciAction<MatInfo>> actions = new ArrayList<>();
		
		actions.add(new MatActionInsert(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
