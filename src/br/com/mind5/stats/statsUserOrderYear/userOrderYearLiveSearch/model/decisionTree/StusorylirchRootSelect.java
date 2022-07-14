package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action.StusorylirchVisiMergeToSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.checker.StusorylirchCheckRead;


public final class StusorylirchRootSelect extends DeciTreeTemplateWrite<StusorylirchInfo> {
	
	public StusorylirchRootSelect(DeciTreeOption<StusorylirchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorylirchInfo> buildCheckerHook(DeciTreeOption<StusorylirchInfo> option) {
		List<ModelChecker<StusorylirchInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorylirchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusorylirchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorylirchInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorylirchInfo> option) {
		List<ActionStd<StusorylirchInfo>> actions = new ArrayList<>();

		ActionStd<StusorylirchInfo> select = new ActionStdCommom<StusorylirchInfo>(option, StusorylirchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
