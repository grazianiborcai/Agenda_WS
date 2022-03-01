package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdEmptifyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action.SowotagrVisiRootDelete;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.checker.SowotagrCheckExistMonth;


public final class SowotagrNodeDeleteMonth extends DeciTreeTemplateWrite<SowotagrInfo> {
	
	public SowotagrNodeDeleteMonth(DeciTreeOption<SowotagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotagrInfo> buildCheckerHook(DeciTreeOption<SowotagrInfo> option) {
		List<ModelChecker<SowotagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowotagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowotagrCheckExistMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotagrInfo> option) {
		List<ActionStd<SowotagrInfo>> actions = new ArrayList<>();

		ActionStd<SowotagrInfo> select = new SowotagrRootSelectMonth(option).toAction();
		ActionLazy<SowotagrInfo> delete = new ActionLazyCommom<SowotagrInfo>(option.conn, option.schemaName, SowotagrVisiRootDelete.class);
		
		select.addPostAction(delete);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowotagrInfo>> buildActionsOnFailedHook(DeciTreeOption<SowotagrInfo> option) {
		List<ActionStd<SowotagrInfo>> actions = new ArrayList<>();

		ActionStd<SowotagrInfo> emptify = new ActionStdEmptifyCommom<SowotagrInfo>(SowotagrInfo.class);
		
		actions.add(emptify);
		return actions;
	}
}
