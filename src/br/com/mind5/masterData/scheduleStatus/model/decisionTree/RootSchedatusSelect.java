package br.com.mind5.masterData.scheduleStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.scheduleStatus.model.action.StdSchedatusDaoSelect;
import br.com.mind5.masterData.scheduleStatus.model.checker.SchedatusCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootSchedatusSelect extends DeciTreeTemplateReadV1<SchedatusInfo> {
	
	public RootSchedatusSelect(DeciTreeOption<SchedatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedatusInfo> buildCheckerHook(DeciTreeOption<SchedatusInfo> option) {
		List<ModelCheckerV1<SchedatusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedatusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedatusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<SchedatusInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedatusInfo> option) {
		List<ActionStdV1<SchedatusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedatusInfo> select = new StdSchedatusDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
