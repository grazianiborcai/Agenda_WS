package br.com.mind5.masterData.genderSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.genderSearch.info.GendarchInfo;
import br.com.mind5.masterData.genderSearch.model.action.StdGendarchDaoSelect;
import br.com.mind5.masterData.genderSearch.model.checker.GendarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootGendarchSelect extends DeciTreeTemplateReadV2<GendarchInfo> {
	
	public RootGendarchSelect(DeciTreeOption<GendarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<GendarchInfo> buildCheckerHook(DeciTreeOption<GendarchInfo> option) {
		List<ModelCheckerV1<GendarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<GendarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new GendarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<GendarchInfo>> buildActionsOnPassedHook(DeciTreeOption<GendarchInfo> option) {
		List<ActionStdV1<GendarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<GendarchInfo> select = new StdGendarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
