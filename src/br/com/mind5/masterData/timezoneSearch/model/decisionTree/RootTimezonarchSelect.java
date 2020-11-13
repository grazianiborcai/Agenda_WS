package br.com.mind5.masterData.timezoneSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;
import br.com.mind5.masterData.timezoneSearch.model.action.StdTimezonarchDaoSelect;
import br.com.mind5.masterData.timezoneSearch.model.checker.TimezonarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootTimezonarchSelect extends DeciTreeTemplateRead<TimezonarchInfo> {
	
	public RootTimezonarchSelect(DeciTreeOption<TimezonarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<TimezonarchInfo> buildCheckerHook(DeciTreeOption<TimezonarchInfo> option) {
		List<ModelChecker<TimezonarchInfo>> queue = new ArrayList<>();		
		ModelChecker<TimezonarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new TimezonarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<TimezonarchInfo>> buildActionsOnPassedHook(DeciTreeOption<TimezonarchInfo> option) {
		List<ActionStd<TimezonarchInfo>> actions = new ArrayList<>();
		
		ActionStd<TimezonarchInfo> select = new StdTimezonarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
