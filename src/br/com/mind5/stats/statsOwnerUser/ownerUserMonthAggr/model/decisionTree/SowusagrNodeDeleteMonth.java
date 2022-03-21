package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.action.SowusagrVisiRootDelete;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.checker.SowusagrCheckExistMonth;


public final class SowusagrNodeDeleteMonth extends DeciTreeTemplateWrite<SowusagrInfo> {
	
	public SowusagrNodeDeleteMonth(DeciTreeOption<SowusagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusagrInfo> buildCheckerHook(DeciTreeOption<SowusagrInfo> option) {
		List<ModelChecker<SowusagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowusagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowusagrCheckExistMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusagrInfo> option) {
		List<ActionStd<SowusagrInfo>> actions = new ArrayList<>();

		ActionStd<SowusagrInfo> select = new SowusagrRootSelectMonth(option).toAction();
		ActionLazy<SowusagrInfo> delete = new ActionLazyCommom<SowusagrInfo>(option, SowusagrVisiRootDelete.class);
		
		select.addPostAction(delete);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowusagrInfo>> buildActionsOnFailedHook(DeciTreeOption<SowusagrInfo> option) {
		List<ActionStd<SowusagrInfo>> actions = new ArrayList<>();

		ActionStd<SowusagrInfo> emptify = new ActionStdEmptifyCommom<SowusagrInfo>(SowusagrInfo.class);
		
		actions.add(emptify);
		return actions;
	}
}
