package br.com.mind5.business.calendarDateSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.business.calendarDateSearch.model.action.StdCalatarchMergeToSelect;
import br.com.mind5.business.calendarDateSearch.model.checker.CalatarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCalatarchSelect extends DeciTreeTemplateRead<CalatarchInfo> {
	
	public RootCalatarchSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalatarchInfo> buildCheckerHook(DeciTreeOption<CalatarchInfo> option) {
		List<ModelChecker<CalatarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CalatarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalatarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CalatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CalatarchInfo> option) {
		List<ActionStd<CalatarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CalatarchInfo> mergeToSelect = new StdCalatarchMergeToSelect(option);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
