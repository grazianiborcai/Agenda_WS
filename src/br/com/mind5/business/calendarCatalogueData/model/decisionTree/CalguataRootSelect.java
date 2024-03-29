package br.com.mind5.business.calendarCatalogueData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarCatalogueData.model.action.CalguataVisiMergeCalate;
import br.com.mind5.business.calendarCatalogueData.model.action.CalguataVisiPruneAged;
import br.com.mind5.business.calendarCatalogueData.model.action.CalguataVisiPrunePlanata;
import br.com.mind5.business.calendarCatalogueData.model.checker.CalguataCheckRead;
import br.com.mind5.business.calendarCatalogueData.model.checker.CalguataCheckYearMonth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CalguataRootSelect extends DeciTreeTemplateRead<CalguataInfo> {
	
	public CalguataRootSelect(DeciTreeOption<CalguataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalguataInfo> buildCheckerHook(DeciTreeOption<CalguataInfo> option) {
		List<ModelChecker<CalguataInfo>> queue = new ArrayList<>();		
		ModelChecker<CalguataInfo> checker;	
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CalguataInfo>> buildActionsOnPassedHook(DeciTreeOption<CalguataInfo> option) {
		List<ActionStd<CalguataInfo>> actions = new ArrayList<>();		
		
		ActionStd<CalguataInfo> mergeCalate = new ActionStdCommom<CalguataInfo>(option, CalguataVisiMergeCalate.class);
		ActionLazy<CalguataInfo> pruneAged = new ActionLazyCommom<CalguataInfo>(option, CalguataVisiPruneAged.class);
		ActionLazy<CalguataInfo> prunePlanata = new ActionLazyCommom<CalguataInfo>(option, CalguataVisiPrunePlanata.class);
		
		mergeCalate.addPostAction(pruneAged);
		pruneAged.addPostAction(prunePlanata);
		
		actions.add(mergeCalate);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
