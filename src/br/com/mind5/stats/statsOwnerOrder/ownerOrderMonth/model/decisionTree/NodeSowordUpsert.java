package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.LazySowordSowordagrUpsert;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.StdSowordEnforceZerofy;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.StdSowordMergeSowordive;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.checker.SowordCheckSowordive;


public final class NodeSowordUpsert extends DeciTreeTemplateWrite<SowordInfo> {
	
	public NodeSowordUpsert(DeciTreeOption<SowordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordInfo> buildCheckerHook(DeciTreeOption<SowordInfo> option) {
		List<ModelChecker<SowordInfo>> queue = new ArrayList<>();
		ModelChecker<SowordInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowordCheckSowordive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordInfo> option) {
		List<ActionStd<SowordInfo>> actions = new ArrayList<>();

		ActionStd<SowordInfo> mergeSowordive = new StdSowordMergeSowordive(option);
		ActionLazy<SowordInfo> upsertSowordagr = new LazySowordSowordagrUpsert(option.conn, option.schemaName);
		
		mergeSowordive.addPostAction(upsertSowordagr);
		
		
		actions.add(mergeSowordive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowordInfo>> buildActionsOnFailedHook(DeciTreeOption<SowordInfo> option) {
		List<ActionStd<SowordInfo>> actions = new ArrayList<>();

		ActionStd<SowordInfo> zerofy = new StdSowordEnforceZerofy(option);
		ActionLazy<SowordInfo> upsertSowordagr = new LazySowordSowordagrUpsert(option.conn, option.schemaName);
		
		zerofy.addPostAction(upsertSowordagr);
		
		
		actions.add(zerofy);
		return actions;
	}
}
