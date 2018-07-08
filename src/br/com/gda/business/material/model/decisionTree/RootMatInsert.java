package br.com.gda.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.checker.MatCheckCateg;
import br.com.gda.business.material.model.checker.MatCheckCurrency;
import br.com.gda.business.material.model.checker.MatCheckGenField;
import br.com.gda.business.material.model.checker.MatCheckGroup;
import br.com.gda.business.material.model.checker.MatCheckLangu;
import br.com.gda.business.material.model.checker.MatCheckOwner;
import br.com.gda.business.material.model.checker.MatCheckType;
import br.com.gda.business.material.model.checker.MatCheckUnit;
import br.com.gda.business.material.model.checker.MatCheckWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatInsert implements DeciTree<MatInfo> {
	private DeciTree<MatInfo> tree;
	
	
	public RootMatInsert(DeciTreeOption<MatInfo> option) {
		DeciTreeHelperOption<MatInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatInfo> buildDecisionChecker(DeciTreeOption<MatInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new MatCheckWrite();
		queue.add(checker);
		
		checker = new MatCheckGenField();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckCurrency(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckUnit(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckCateg(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckGroup(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatCheckType(checkerOption);
		queue.add(checker);
		
		//TODO: verificar se barcode ou código do fornecedor já existe  no banco
		//TODO: verificar a unidade de medida. Servi�o somente pode ter tempo e produto somente pode ter unidade
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<MatInfo>> buildActionsOnPassed(DeciTreeOption<MatInfo> option) {
		List<DeciAction<MatInfo>> actions = new ArrayList<>();		
		DeciAction<MatInfo> actionInsertAttr = new ActionMatInsertAttr(option);
		
		DeciActionHandler<MatInfo> insertTxt = new HandlerMatInsertTxt(option.conn, option.schemaName);		
		actionInsertAttr.addPostAction(insertTxt);		
		
		DeciActionHandler<MatInfo> selectMat = new HandlerMatSelect(option.conn, option.schemaName);		
		actionInsertAttr.addPostAction(selectMat);	
		
		actions.add(actionInsertAttr);		
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
	
	
	
	@Override public DeciAction<MatInfo> toAction() {
		return tree.toAction();
	}
}
