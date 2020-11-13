package br.com.mind5.business.scheduleRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.business.scheduleRange.model.action.StdSchedageMergeToSelect;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckLangu;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckOwner;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckRead;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckStore;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedageSelect extends DeciTreeTemplateWriteV2<SchedageInfo> {
	
	public RootSchedageSelect(DeciTreeOption<SchedageInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedageInfo> buildCheckerHook(DeciTreeOption<SchedageInfo> option) {		
		List<ModelCheckerV1<SchedageInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedageInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedageCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedageCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedageCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedageCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<SchedageInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedageInfo> option) {
		List<ActionStdV2<SchedageInfo>> actions = new ArrayList<>();
		
		ActionStdV2<SchedageInfo> select = new StdSchedageMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
