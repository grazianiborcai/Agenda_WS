package br.com.mind5.business.calendarTimeStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.model.action.LazyCalimoreNodeSelect;
import br.com.mind5.business.calendarTimeStore.model.action.StdCalimoreMergeCalate;
import br.com.mind5.business.calendarTimeStore.model.checker.CalimoreCheckOwner;
import br.com.mind5.business.calendarTimeStore.model.checker.CalimoreCheckRead;
import br.com.mind5.business.calendarTimeStore.model.checker.CalimoreCheckStore;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCalimoreSelect extends DeciTreeTemplateWriteV2<CalimoreInfo> {
	
	public RootCalimoreSelect(DeciTreeOption<CalimoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CalimoreInfo> buildCheckerHook(DeciTreeOption<CalimoreInfo> option) {
		List<ModelCheckerV1<CalimoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CalimoreInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimoreCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimoreCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimoreCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CalimoreInfo>> buildActionsOnPassedHook(DeciTreeOption<CalimoreInfo> option) {
		List<ActionStdV1<CalimoreInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CalimoreInfo> mergeCalate = new StdCalimoreMergeCalate(option);
		ActionLazyV1<CalimoreInfo> select = new LazyCalimoreNodeSelect(option.conn, option.schemaName);
		
		mergeCalate.addPostAction(select);
		
		actions.add(mergeCalate);
		return actions;
	}
}
