package br.com.mind5.business.scheduleSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.model.action.StdSchedarchMergeToSelect;
import br.com.mind5.business.scheduleSearch.model.checker.SchedarchCheckLangu;
import br.com.mind5.business.scheduleSearch.model.checker.SchedarchCheckOwner;
import br.com.mind5.business.scheduleSearch.model.checker.SchedarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedarchSelect extends DeciTreeTemplateWrite<SchedarchInfo> {
	
	public RootSchedarchSelect(DeciTreeOption<SchedarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedarchInfo> buildCheckerHook(DeciTreeOption<SchedarchInfo> option) {
		List<ModelCheckerV1<SchedarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedarchInfo> option) {
		List<ActionStdV1<SchedarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedarchInfo> select = new StdSchedarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
