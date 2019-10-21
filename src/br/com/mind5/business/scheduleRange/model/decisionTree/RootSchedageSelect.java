package br.com.mind5.business.scheduleRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.business.scheduleRange.model.action.StdSchedageMergeToSelect;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckLangu;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckOwner;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckRead;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedageSelect extends DeciTreeWriteTemplate<SchedageInfo> {
	
	public RootSchedageSelect(DeciTreeOption<SchedageInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedageInfo> buildDecisionCheckerHook(DeciTreeOption<SchedageInfo> option) {		
		List<ModelChecker<SchedageInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedageInfo> checker;
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedageInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedageInfo> option) {
		List<ActionStd<SchedageInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedageInfo> select = new StdSchedageMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
