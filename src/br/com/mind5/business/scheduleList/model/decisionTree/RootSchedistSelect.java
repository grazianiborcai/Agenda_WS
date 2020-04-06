package br.com.mind5.business.scheduleList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.business.scheduleList.model.action.StdSchedistMergeToSelect;
import br.com.mind5.business.scheduleList.model.checker.SchedistCheckLangu;
import br.com.mind5.business.scheduleList.model.checker.SchedistCheckOwner;
import br.com.mind5.business.scheduleList.model.checker.SchedistCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedistSelect extends DeciTreeTemplateWrite<SchedistInfo> {
	
	public RootSchedistSelect(DeciTreeOption<SchedistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedistInfo> buildCheckerHook(DeciTreeOption<SchedistInfo> option) {
		List<ModelCheckerV1<SchedistInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedistInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedistCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedistCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedistCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedistInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedistInfo> option) {
		List<ActionStdV1<SchedistInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedistInfo> select = new StdSchedistMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
