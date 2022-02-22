package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action.LazyStedmonRootSelect;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action.StdStedmonMergeCalonthLtm;


public final class RootStedmonSelectLtm extends DeciTreeTemplateWrite<StedmonInfo> {
	
	public RootStedmonSelectLtm(DeciTreeOption<StedmonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StedmonInfo> buildCheckerHook(DeciTreeOption<StedmonInfo> option) {
		List<ModelChecker<StedmonInfo>> queue = new ArrayList<>();		
		ModelChecker<StedmonInfo> checker;

		checker = new ModelCheckerDummy<StedmonInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StedmonInfo>> buildActionsOnPassedHook(DeciTreeOption<StedmonInfo> option) {
		List<ActionStd<StedmonInfo>> actions = new ArrayList<>();

		ActionStd<StedmonInfo> mergeCalonthLtm = new StdStedmonMergeCalonthLtm(option);
		ActionLazy<StedmonInfo> select = new LazyStedmonRootSelect(option.conn, option.schemaName);
		
		mergeCalonthLtm.addPostAction(select);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
