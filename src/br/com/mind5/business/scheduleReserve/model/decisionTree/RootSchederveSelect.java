package br.com.mind5.business.scheduleReserve.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.business.scheduleReserve.model.action.StdSchederveMergeToSelect;
import br.com.mind5.business.scheduleReserve.model.checker.SchederveCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootSchederveSelect extends DeciTreeTemplateReadV2<SchederveInfo> {
	
	public RootSchederveSelect(DeciTreeOption<SchederveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchederveInfo> buildCheckerHook(DeciTreeOption<SchederveInfo> option) {
		List<ModelCheckerV1<SchederveInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchederveInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchederveCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<SchederveInfo>> buildActionsOnPassedHook(DeciTreeOption<SchederveInfo> option) {
		List<ActionStdV2<SchederveInfo>> actions = new ArrayList<>();	
		
		ActionStdV2<SchederveInfo> select = new StdSchederveMergeToSelect(option);

		actions.add(select);			
		return actions;
	}
}
