package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.action.LazyMatoreMergeMat;
import br.com.gda.business.materialStore.model.action.LazyMatoreMergeUsername;
import br.com.gda.business.materialStore.model.action.LazyMatoreNodeUpdate;
import br.com.gda.business.materialStore.model.action.StdMatoreEnforceLChanged;
import br.com.gda.business.materialStore.model.checker.MatoreCheckExist;
import br.com.gda.business.materialStore.model.checker.MatoreCheckMat;
import br.com.gda.business.materialStore.model.checker.MatoreCheckOwner;
import br.com.gda.business.materialStore.model.checker.MatoreCheckStorauth;
import br.com.gda.business.materialStore.model.checker.MatoreCheckStore;
import br.com.gda.business.materialStore.model.checker.MatoreCheckWrite;
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

public final class RootMatoreUpdate implements DeciTree<MatoreInfo> {
	private DeciTree<MatoreInfo> tree;
	
	
	public RootMatoreUpdate(DeciTreeOption<MatoreInfo> option) {
		DeciTreeHelperOption<MatoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatoreInfo> buildDecisionChecker(DeciTreeOption<MatoreInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new MatoreCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatoreCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatoreCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatoreCheckMat(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatoreCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatoreCheckStorauth(checkerOption);
		queue.add(checker);	
		//TODO: criar Endpoint par modificar precos de todas as lojas ao mesmo tempo. Pode ser necessario converter moedas
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatoreInfo>> buildActionsOnPassed(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoreInfo> enforceLChanged = new StdMatoreEnforceLChanged(option);
		ActionLazy<MatoreInfo> enforceLChangedBy = new LazyMatoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> mergeMat = new LazyMatoreMergeMat(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> nodeUpdate = new LazyMatoreNodeUpdate(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(mergeMat);
		mergeMat.addPostAction(nodeUpdate);
				
		actions.add(enforceLChanged);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatoreInfo> toAction() {
		return tree.toAction();
	}
}
