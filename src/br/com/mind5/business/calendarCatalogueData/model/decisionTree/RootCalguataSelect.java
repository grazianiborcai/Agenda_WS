package br.com.mind5.business.calendarCatalogueData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarCatalogueData.model.action.LazyCalguataMergePlanata;
import br.com.mind5.business.calendarCatalogueData.model.action.LazyCalguataPruneAged;
import br.com.mind5.business.calendarCatalogueData.model.action.StdCalguataMergeCalate;
import br.com.mind5.business.calendarCatalogueData.model.checker.CalguataCheckRead;
import br.com.mind5.business.calendarCatalogueData.model.checker.CalguataCheckYearMonth;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCalguataSelect extends DeciTreeTemplateWriteV2<CalguataInfo> {
	
	public RootCalguataSelect(DeciTreeOption<CalguataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CalguataInfo> buildCheckerHook(DeciTreeOption<CalguataInfo> option) {
		List<ModelCheckerV1<CalguataInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CalguataInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalguataCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalguataCheckYearMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CalguataInfo>> buildActionsOnPassedHook(DeciTreeOption<CalguataInfo> option) {
		List<ActionStdV1<CalguataInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<CalguataInfo> mergeCalate = new StdCalguataMergeCalate(option);
		ActionLazyV1<CalguataInfo> pruneAged = new LazyCalguataPruneAged(option.conn, option.schemaName);
		ActionLazyV1<CalguataInfo> mergePlanata = new LazyCalguataMergePlanata(option.conn, option.schemaName);
		
		mergeCalate.addPostAction(pruneAged);
		pruneAged.addPostAction(mergePlanata);
		
		actions.add(mergeCalate);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}