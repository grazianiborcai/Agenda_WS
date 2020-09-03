package br.com.mind5.masterData.weekday.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.action.LazyWeekdayRootSelect;
import br.com.mind5.masterData.weekday.model.action.StdWeekdayMergeWeekdarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootWeekdaySearch extends DeciTreeTemplateWriteV2<WeekdayInfo> {
	
	public RootWeekdaySearch(DeciTreeOption<WeekdayInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<WeekdayInfo> buildCheckerHook(DeciTreeOption<WeekdayInfo> option) {
		List<ModelCheckerV1<WeekdayInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<WeekdayInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<WeekdayInfo>> buildActionsOnPassedHook(DeciTreeOption<WeekdayInfo> option) {
		List<ActionStdV1<WeekdayInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<WeekdayInfo> mergeWeekdarch = new StdWeekdayMergeWeekdarch(option);		
		ActionLazyV1<WeekdayInfo> select = new LazyWeekdayRootSelect(option.conn, option.schemaName);
		
		mergeWeekdarch.addPostAction(select);
		
		actions.add(mergeWeekdarch);			
		return actions;
	}
}
