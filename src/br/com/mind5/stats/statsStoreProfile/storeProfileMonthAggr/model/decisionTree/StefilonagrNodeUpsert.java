package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.checker.StefilonagrCheckExist;


public final class StefilonagrNodeUpsert extends DeciTreeTemplateWrite<StefilonagrInfo> {
	
	public StefilonagrNodeUpsert(DeciTreeOption<StefilonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StefilonagrInfo> buildCheckerHook(DeciTreeOption<StefilonagrInfo> option) {
		List<ModelChecker<StefilonagrInfo>> queue = new ArrayList<>();		
		ModelChecker<StefilonagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StefilonagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StefilonagrInfo>> buildActionsOnPassedHook(DeciTreeOption<StefilonagrInfo> option) {
		List<ActionStd<StefilonagrInfo>> actions = new ArrayList<>();

		ActionStd<StefilonagrInfo> delete = new StefilonagrRootDelete(option).toAction();
		ActionStd<StefilonagrInfo> insert = new StefilonagrRootInsert(option).toAction();
		
		actions.add(delete);
		actions.add(insert);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StefilonagrInfo>> buildActionsOnFailedHook(DeciTreeOption<StefilonagrInfo> option) {
		List<ActionStd<StefilonagrInfo>> actions = new ArrayList<>();

		ActionStd<StefilonagrInfo> insert = new StefilonagrRootInsert(option).toAction();
		
		actions.add(insert);
		return actions;
	}
}
