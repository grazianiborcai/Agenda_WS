package br.com.mind5.masterData.moonPhase.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.action.LazyMoonaseRootSelect;
import br.com.mind5.masterData.moonPhase.model.action.StdMoonaseMergeMoonasarch;
import br.com.mind5.masterData.moonPhase.model.checker.MoonaseCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class RootMoonaseSearch extends DeciTreeTemplateWriteV1<MoonaseInfo> {
	
	public RootMoonaseSearch(DeciTreeOption<MoonaseInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MoonaseInfo> buildCheckerHook(DeciTreeOption<MoonaseInfo> option) {
		List<ModelCheckerV1<MoonaseInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MoonaseInfo> checker;	

		checker = new MoonaseCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MoonaseInfo>> buildActionsOnPassedHook(DeciTreeOption<MoonaseInfo> option) {
		List<ActionStdV1<MoonaseInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<MoonaseInfo> mergeMoonasarch = new StdMoonaseMergeMoonasarch(option);		
		ActionLazyV1<MoonaseInfo> select = new LazyMoonaseRootSelect(option.conn, option.schemaName);
		
		mergeMoonasarch.addPostAction(select);
		
		actions.add(mergeMoonasarch);			
		return actions;
	}
}
