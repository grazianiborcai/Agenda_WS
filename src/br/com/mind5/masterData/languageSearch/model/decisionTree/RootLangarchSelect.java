package br.com.mind5.masterData.languageSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.masterData.languageSearch.model.action.StdLangarchDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootLangarchSelect extends DeciTreeTemplateReadV2<LangarchInfo> {
	
	public RootLangarchSelect(DeciTreeOption<LangarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<LangarchInfo> buildCheckerHook(DeciTreeOption<LangarchInfo> option) {
		List<ModelCheckerV1<LangarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<LangarchInfo> checker;
		
		checker = new ModelCherckerTrue<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<LangarchInfo>> buildActionsOnPassedHook(DeciTreeOption<LangarchInfo> option) {
		List<ActionStdV1<LangarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<LangarchInfo> select = new StdLangarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
