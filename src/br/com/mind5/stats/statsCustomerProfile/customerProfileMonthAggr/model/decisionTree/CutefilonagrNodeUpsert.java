package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.checker.CutefilonagrCheckExist;


public final class CutefilonagrNodeUpsert extends DeciTreeTemplateWrite<CutefilonagrInfo> {
	
	public CutefilonagrNodeUpsert(DeciTreeOption<CutefilonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CutefilonagrInfo> buildCheckerHook(DeciTreeOption<CutefilonagrInfo> option) {
		List<ModelChecker<CutefilonagrInfo>> queue = new ArrayList<>();		
		ModelChecker<CutefilonagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CutefilonagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CutefilonagrInfo>> buildActionsOnPassedHook(DeciTreeOption<CutefilonagrInfo> option) {
		List<ActionStd<CutefilonagrInfo>> actions = new ArrayList<>();

		ActionStd<CutefilonagrInfo> delete = new CutefilonagrRootDelete(option).toAction();
		ActionStd<CutefilonagrInfo> insert = new CutefilonagrRootInsert(option).toAction();
		
		actions.add(delete);
		actions.add(insert);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CutefilonagrInfo>> buildActionsOnFailedHook(DeciTreeOption<CutefilonagrInfo> option) {
		List<ActionStd<CutefilonagrInfo>> actions = new ArrayList<>();

		ActionStd<CutefilonagrInfo> insert = new CutefilonagrRootInsert(option).toAction();
		
		actions.add(insert);
		return actions;
	}
}
