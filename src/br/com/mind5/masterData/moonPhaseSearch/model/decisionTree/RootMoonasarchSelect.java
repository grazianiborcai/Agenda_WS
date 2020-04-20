package br.com.mind5.masterData.moonPhaseSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.masterData.moonPhaseSearch.model.action.StdMoonasarchDaoSelect;
import br.com.mind5.masterData.moonPhaseSearch.model.checker.MoonasarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMoonasarchSelect extends DeciTreeTemplateReadV2<MoonasarchInfo> {
	
	public RootMoonasarchSelect(DeciTreeOption<MoonasarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MoonasarchInfo> buildCheckerHook(DeciTreeOption<MoonasarchInfo> option) {
		List<ModelCheckerV1<MoonasarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MoonasarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MoonasarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<MoonasarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MoonasarchInfo> option) {
		List<ActionStdV1<MoonasarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MoonasarchInfo> select = new StdMoonasarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
