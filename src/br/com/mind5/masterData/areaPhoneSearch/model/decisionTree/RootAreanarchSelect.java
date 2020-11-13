package br.com.mind5.masterData.areaPhoneSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;
import br.com.mind5.masterData.areaPhoneSearch.model.action.StdAreanarchDaoSelect;
import br.com.mind5.masterData.areaPhoneSearch.model.checker.AreanarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootAreanarchSelect extends DeciTreeTemplateReadV2<AreanarchInfo> {
	
	public RootAreanarchSelect(DeciTreeOption<AreanarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AreanarchInfo> buildCheckerHook(DeciTreeOption<AreanarchInfo> option) {
		List<ModelCheckerV1<AreanarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AreanarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AreanarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<AreanarchInfo>> buildActionsOnPassedHook(DeciTreeOption<AreanarchInfo> option) {
		List<ActionStdV2<AreanarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<AreanarchInfo> select = new StdAreanarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
