package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.business.masterData.model.action.StdGenderSelect;
import br.com.mind5.business.masterData.model.checker.GenderCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootGenderSelect extends DeciTreeTemplateRead<GenderInfo> {
	
	public RootGenderSelect(DeciTreeOption<GenderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<GenderInfo> buildCheckerHook(DeciTreeOption<GenderInfo> option) {
		List<ModelCheckerV1<GenderInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<GenderInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new GenderCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<GenderInfo>> buildActionsOnPassedHook(DeciTreeOption<GenderInfo> option) {
		List<ActionStdV1<GenderInfo>> actions = new ArrayList<>();
		
		ActionStdV1<GenderInfo> select = new StdGenderSelect(option);
		
		actions.add(select);
		return actions;
	}
}
