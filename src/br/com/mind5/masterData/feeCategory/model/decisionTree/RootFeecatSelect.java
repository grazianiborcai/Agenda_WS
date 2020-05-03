package br.com.mind5.masterData.feeCategory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.action.StdFeecatDaoSelect;
import br.com.mind5.masterData.feeCategory.model.checker.FeecatCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFeecatSelect extends DeciTreeTemplateReadV2<FeecatInfo> {
	
	public RootFeecatSelect(DeciTreeOption<FeecatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FeecatInfo> buildCheckerHook(DeciTreeOption<FeecatInfo> option) {
		List<ModelCheckerV1<FeecatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FeecatInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FeecatCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<FeecatInfo>> buildActionsOnPassedHook(DeciTreeOption<FeecatInfo> option) {
		List<ActionStdV1<FeecatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FeecatInfo> select = new StdFeecatDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
