package br.com.mind5.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.action.LazyMatockNodeBalanceL2;
import br.com.mind5.business.materialStock.model.action.StdMatockEnforceBalance;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatockBalanceL1 extends DeciTreeTemplateWriteV2<MatockInfo> {
	
	public NodeMatockBalanceL1(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatockInfo> buildCheckerHook(DeciTreeOption<MatockInfo> option) {
		List<ModelCheckerV1<MatockInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatockInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatockInfo>> buildActionsOnPassedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStdV2<MatockInfo>> actions = new ArrayList<>();

		ActionStdV2<MatockInfo> enforceBalance = new StdMatockEnforceBalance(option);
		ActionLazy<MatockInfo> balanceL2 = new LazyMatockNodeBalanceL2(option.conn, option.schemaName);
		
		enforceBalance.addPostAction(balanceL2);
		
		actions.add(enforceBalance);
		return actions;
	}
}
