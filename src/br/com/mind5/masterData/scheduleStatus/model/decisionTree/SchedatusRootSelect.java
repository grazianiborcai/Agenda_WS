package br.com.mind5.masterData.scheduleStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.scheduleStatus.model.action.SchedatusVisiDaoSelect;
import br.com.mind5.masterData.scheduleStatus.model.checker.SchedatusCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class SchedatusRootSelect extends DeciTreeTemplateRead<SchedatusInfo> {
	
	public SchedatusRootSelect(DeciTreeOption<SchedatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedatusInfo> buildCheckerHook(DeciTreeOption<SchedatusInfo> option) {
		List<ModelChecker<SchedatusInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedatusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedatusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<SchedatusInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedatusInfo> option) {
		List<ActionStd<SchedatusInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedatusInfo> select = new ActionStdCommom<SchedatusInfo>(option, SchedatusVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
