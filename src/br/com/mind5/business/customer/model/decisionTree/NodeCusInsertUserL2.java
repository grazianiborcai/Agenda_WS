package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusNodeSnapshot;
import br.com.mind5.business.customer.model.action.StdCusMergeUserarch;
import br.com.mind5.business.customer.model.action.StdCusUserInsert;
import br.com.mind5.business.customer.model.checker.CusCheckUserarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeCusInsertUserL2 extends DeciTreeTemplateWrite<CusInfo> {

	public NodeCusInsertUserL2(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckUserarch(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> mergeUserarch = new StdCusMergeUserarch(option);
		ActionLazy<CusInfo> snapshot = new LazyCusNodeSnapshot(option.conn, option.schemaName);
		
		mergeUserarch.addPostAction(snapshot);
		
		actions.add(mergeUserarch);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnFailedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> insertUser = new StdCusUserInsert(option);
		ActionLazy<CusInfo> snapshot = new LazyCusNodeSnapshot(option.conn, option.schemaName);
		
		insertUser.addPostAction(snapshot);
		
		actions.add(insertUser);	
		return actions;
	}
}
