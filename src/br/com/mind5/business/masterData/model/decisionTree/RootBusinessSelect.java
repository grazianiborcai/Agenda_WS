package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.BusinessInfo;
import br.com.mind5.business.masterData.model.action.StdBusinessSelect;
import br.com.mind5.business.masterData.model.checker.BusinessCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootBusinessSelect extends DeciTreeTemplateRead<BusinessInfo> {
	
	public RootBusinessSelect(DeciTreeOption<BusinessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<BusinessInfo> buildCheckerHook(DeciTreeOption<BusinessInfo> option) {
		List<ModelCheckerV1<BusinessInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<BusinessInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BusinessCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<BusinessInfo>> buildActionsOnPassedHook(DeciTreeOption<BusinessInfo> option) {
		List<ActionStdV1<BusinessInfo>> actions = new ArrayList<>();
		
		ActionStdV1<BusinessInfo> select = new StdBusinessSelect(option);
		
		actions.add(select);
		return actions;
	}
}
