package br.com.mind5.masterData.feeCategorySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;
import br.com.mind5.masterData.feeCategorySearch.model.action.StdFeecatarchDaoSelect;
import br.com.mind5.masterData.feeCategorySearch.model.checker.FeecatarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFeecatarchSelect extends DeciTreeTemplateReadV2<FeecatarchInfo> {
	
	public RootFeecatarchSelect(DeciTreeOption<FeecatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FeecatarchInfo> buildCheckerHook(DeciTreeOption<FeecatarchInfo> option) {
		List<ModelCheckerV1<FeecatarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FeecatarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FeecatarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<FeecatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FeecatarchInfo> option) {
		List<ActionStdV2<FeecatarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FeecatarchInfo> select = new StdFeecatarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
