package br.com.mind5.stats.statsStoreAccount.storeAccount.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccount.model.action.StdStoracEnforceZerofy;
import br.com.mind5.stats.statsStoreAccount.storeAccount.model.action.StdStoracSuccess;
import br.com.mind5.stats.statsStoreAccount.storeAccount.model.checker.StoracCheckHasData;


public final class NodeStoracZerofy extends DeciTreeTemplateWrite<StoracInfo> {
	
	public NodeStoracZerofy(DeciTreeOption<StoracInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoracInfo> buildCheckerHook(DeciTreeOption<StoracInfo> option) {
		List<ModelChecker<StoracInfo>> queue = new ArrayList<>();		
		ModelChecker<StoracInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.FAILED;		
		checker = new StoracCheckHasData(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoracInfo>> buildActionsOnPassedHook(DeciTreeOption<StoracInfo> option) {
		List<ActionStd<StoracInfo>> actions = new ArrayList<>();

		ActionStd<StoracInfo> success = new StdStoracSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoracInfo>> buildActionsOnFailedHook(DeciTreeOption<StoracInfo> option) {
		List<ActionStd<StoracInfo>> actions = new ArrayList<>();

		ActionStd<StoracInfo> zerofy = new StdStoracEnforceZerofy(option);
		
		actions.add(zerofy);
		return actions;
	}
}
