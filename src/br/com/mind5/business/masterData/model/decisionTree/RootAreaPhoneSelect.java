package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.AreaPhoneInfo;
import br.com.mind5.business.masterData.model.action.StdAreaPhoneSelect;
import br.com.mind5.business.masterData.model.checker.AreaPhoneCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootAreaPhoneSelect extends DeciTreeTemplateReadV1<AreaPhoneInfo> {
	
	public RootAreaPhoneSelect(DeciTreeOption<AreaPhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AreaPhoneInfo> buildCheckerHook(DeciTreeOption<AreaPhoneInfo> option) {
		List<ModelCheckerV1<AreaPhoneInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AreaPhoneInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AreaPhoneCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<AreaPhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<AreaPhoneInfo> option) {
		List<ActionStdV1<AreaPhoneInfo>> actions = new ArrayList<>();
		
		ActionStdV1<AreaPhoneInfo> select = new StdAreaPhoneSelect(option);
		
		actions.add(select);
		return actions;
	}
}
