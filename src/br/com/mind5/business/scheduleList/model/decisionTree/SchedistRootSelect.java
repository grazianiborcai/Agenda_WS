package br.com.mind5.business.scheduleList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.business.scheduleList.model.action.SchedistVisiMergeToSelect;
import br.com.mind5.business.scheduleList.model.checker.SchedistCheckLangu;
import br.com.mind5.business.scheduleList.model.checker.SchedistCheckOwner;
import br.com.mind5.business.scheduleList.model.checker.SchedistCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedistRootSelect extends DeciTreeTemplateWrite<SchedistInfo> {
	
	public SchedistRootSelect(DeciTreeOption<SchedistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedistInfo> buildCheckerHook(DeciTreeOption<SchedistInfo> option) {
		List<ModelChecker<SchedistInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedistInfo> checker;
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedistInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedistInfo> option) {
		List<ActionStd<SchedistInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedistInfo> select = new ActionStdCommom<SchedistInfo>(option, SchedistVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
