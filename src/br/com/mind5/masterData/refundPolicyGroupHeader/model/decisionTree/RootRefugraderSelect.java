package br.com.mind5.masterData.refundPolicyGroupHeader.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;
import br.com.mind5.masterData.refundPolicyGroupHeader.model.action.StdRefugraderDaoSelect;
import br.com.mind5.masterData.refundPolicyGroupHeader.model.checker.RefugraderCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefugraderSelect extends DeciTreeTemplateReadV2<RefugraderInfo> {
	
	public RootRefugraderSelect(DeciTreeOption<RefugraderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefugraderInfo> buildCheckerHook(DeciTreeOption<RefugraderInfo> option) {
		List<ModelCheckerV1<RefugraderInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefugraderInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefugraderCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefugraderInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugraderInfo> option) {
		List<ActionStdV1<RefugraderInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefugraderInfo> select = new StdRefugraderDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
