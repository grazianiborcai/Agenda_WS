package br.com.gda.payment.permissionResponseMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

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
import br.com.gda.payment.permissionResponseMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionResponseMoip.model.action.StdPeresmoipMergeToSelect;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckLangu;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckOwner;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckRead;

public final class RootPeresmoipSelect implements DeciTree<PeresmoipInfo> {
	private DeciTree<PeresmoipInfo> tree;
	
	
	public RootPeresmoipSelect(DeciTreeOption<PeresmoipInfo> option) {
		DeciTreeHelperOption<PeresmoipInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PeresmoipInfo> buildDecisionChecker(DeciTreeOption<PeresmoipInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PeresmoipInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new PeresmoipCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PeresmoipCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PeresmoipCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PeresmoipInfo>> buildActionsOnPassed(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<PeresmoipInfo> select = new StdPeresmoipMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PeresmoipInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PeresmoipInfo> toAction() {
		return tree.toAction();
	}
}
