package br.com.mind5.masterData.areaPhone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.areaPhone.info.AreaneInfo;
import br.com.mind5.masterData.areaPhone.model.action.StdAreaneDaoSelect;
import br.com.mind5.masterData.areaPhone.model.checker.AreaneCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootAreaneSelect extends DeciTreeTemplateReadV2<AreaneInfo> {
	
	public RootAreaneSelect(DeciTreeOption<AreaneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AreaneInfo> buildCheckerHook(DeciTreeOption<AreaneInfo> option) {
		List<ModelCheckerV1<AreaneInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AreaneInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AreaneCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<AreaneInfo>> buildActionsOnPassedHook(DeciTreeOption<AreaneInfo> option) {
		List<ActionStdV2<AreaneInfo>> actions = new ArrayList<>();
		
		ActionStdV2<AreaneInfo> select = new StdAreaneDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
