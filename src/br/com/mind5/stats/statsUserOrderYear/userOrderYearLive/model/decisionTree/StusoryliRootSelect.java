package br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.info.StusoryliInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.model.action.StusoryliVisiMergeToSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.model.checker.StusoryliCheckRead;


public final class StusoryliRootSelect extends DeciTreeTemplateWrite<StusoryliInfo> {
	
	public StusoryliRootSelect(DeciTreeOption<StusoryliInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusoryliInfo> buildCheckerHook(DeciTreeOption<StusoryliInfo> option) {
		List<ModelChecker<StusoryliInfo>> queue = new ArrayList<>();		
		ModelChecker<StusoryliInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusoryliCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusoryliInfo>> buildActionsOnPassedHook(DeciTreeOption<StusoryliInfo> option) {
		List<ActionStd<StusoryliInfo>> actions = new ArrayList<>();

		ActionStd<StusoryliInfo> select = new ActionStdCommom<StusoryliInfo>(option, StusoryliVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
