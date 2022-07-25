package br.com.mind5.masterData.timezone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.masterData.timezone.model.action.TimezoneVisiDaoSelect;
import br.com.mind5.masterData.timezone.model.checker.TimezoneCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class TimezoneRootSelect extends DeciTreeTemplateRead<TimezoneInfo> {
	
	public TimezoneRootSelect(DeciTreeOption<TimezoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<TimezoneInfo> buildCheckerHook(DeciTreeOption<TimezoneInfo> option) {
		List<ModelChecker<TimezoneInfo>> queue = new ArrayList<>();		
		ModelChecker<TimezoneInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new TimezoneCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<TimezoneInfo>> buildActionsOnPassedHook(DeciTreeOption<TimezoneInfo> option) {
		List<ActionStd<TimezoneInfo>> actions = new ArrayList<>();
		
		ActionStd<TimezoneInfo> select = new ActionStdCommom<TimezoneInfo>(option, TimezoneVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
