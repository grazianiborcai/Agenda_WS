package br.com.mind5.masterData.movimentType.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.masterData.movimentType.model.action.StdMamovypeDaoSelect;
import br.com.mind5.masterData.movimentType.model.checker.MamovypeCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMamovypeSelect extends DeciTreeTemplateReadV1<MamovypeInfo> {
	
	public RootMamovypeSelect(DeciTreeOption<MamovypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MamovypeInfo> buildCheckerHook(DeciTreeOption<MamovypeInfo> option) {
		List<ModelCheckerV1<MamovypeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MamovypeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MamovypeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<MamovypeInfo>> buildActionsOnPassedHook(DeciTreeOption<MamovypeInfo> option) {
		List<ActionStdV1<MamovypeInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MamovypeInfo> select = new StdMamovypeDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
