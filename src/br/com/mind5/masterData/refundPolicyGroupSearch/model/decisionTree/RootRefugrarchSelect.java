package br.com.mind5.masterData.refundPolicyGroupSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;
import br.com.mind5.masterData.refundPolicyGroupSearch.model.action.StdRefugrarchDaoSelect;
import br.com.mind5.masterData.refundPolicyGroupSearch.model.checker.RefugrarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefugrarchSelect extends DeciTreeTemplateReadV2<RefugrarchInfo> {
	
	public RootRefugrarchSelect(DeciTreeOption<RefugrarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefugrarchInfo> buildCheckerHook(DeciTreeOption<RefugrarchInfo> option) {
		List<ModelCheckerV1<RefugrarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefugrarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefugrarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefugrarchInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugrarchInfo> option) {
		List<ActionStdV1<RefugrarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefugrarchInfo> select = new StdRefugrarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
