package br.com.mind5.masterData.timezone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.masterData.timezone.model.action.StdTimezoneDaoSelect;
import br.com.mind5.masterData.timezone.model.checker.TimezoneCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootTimezoneSelect extends DeciTreeTemplateReadV2<TimezoneInfo> {
	
	public RootTimezoneSelect(DeciTreeOption<TimezoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<TimezoneInfo> buildCheckerHook(DeciTreeOption<TimezoneInfo> option) {
		List<ModelCheckerV1<TimezoneInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<TimezoneInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new TimezoneCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<TimezoneInfo>> buildActionsOnPassedHook(DeciTreeOption<TimezoneInfo> option) {
		List<ActionStdV2<TimezoneInfo>> actions = new ArrayList<>();
		
		ActionStdV2<TimezoneInfo> select = new StdTimezoneDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
