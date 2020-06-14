package br.com.mind5.masterData.prospectStatusSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;
import br.com.mind5.masterData.prospectStatusSearch.model.action.StdProstarchDaoSelect;
import br.com.mind5.masterData.prospectStatusSearch.model.checker.ProstarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootProstarchSelect extends DeciTreeTemplateWriteV2<ProstarchInfo> {
	
	public RootProstarchSelect(DeciTreeOption<ProstarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<ProstarchInfo> buildCheckerHook(DeciTreeOption<ProstarchInfo> option) {
		List<ModelCheckerV1<ProstarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<ProstarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new ProstarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<ProstarchInfo>> buildActionsOnPassedHook(DeciTreeOption<ProstarchInfo> option) {
		List<ActionStdV1<ProstarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<ProstarchInfo> select = new StdProstarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
