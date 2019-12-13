package br.com.mind5.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.action.LazyMatockNodeBalanceL2;
import br.com.mind5.business.materialStock.model.action.StdMatockEnforceBalance;
import br.com.mind5.business.materialStock.model.checker.MatockCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatockBalanceL1 extends DeciTreeWriteTemplate<MatockInfo> {
	
	public NodeMatockBalanceL1(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatockInfo> buildDecisionCheckerHook(DeciTreeOption<MatockInfo> option) {
		List<ModelChecker<MatockInfo>> queue = new ArrayList<>();		
		ModelChecker<MatockInfo> checker;

		checker = new MatockCheckDummy();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatockInfo>> buildActionsOnPassedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStd<MatockInfo>> actions = new ArrayList<>();

		ActionStd<MatockInfo> enforceBalance = new StdMatockEnforceBalance(option);
		ActionLazy<MatockInfo> balanceL2 = new LazyMatockNodeBalanceL2(option.conn, option.schemaName);
		
		enforceBalance.addPostAction(balanceL2);
		
		actions.add(enforceBalance);
		return actions;
	}
}
