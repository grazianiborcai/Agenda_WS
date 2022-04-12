package br.com.mind5.business.scheduleRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.business.scheduleRange.model.action.SchedageVisiMergeToSelect;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckLangu;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckOwner;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckRead;
import br.com.mind5.business.scheduleRange.model.checker.SchedageCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedageRootSelect extends DeciTreeTemplateWrite<SchedageInfo> {
	
	public SchedageRootSelect(DeciTreeOption<SchedageInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedageInfo> buildCheckerHook(DeciTreeOption<SchedageInfo> option) {		
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedageInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedageInfo> option) {
		List<ActionStd<SchedageInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedageInfo> select = new ActionStdCommom<SchedageInfo>(option, SchedageVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
