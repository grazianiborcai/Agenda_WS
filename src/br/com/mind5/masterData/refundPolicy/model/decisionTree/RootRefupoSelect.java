package br.com.mind5.masterData.refundPolicy.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.masterData.refundPolicy.model.action.StdRefupoDaoSelect;
import br.com.mind5.masterData.refundPolicy.model.checker.RefupoCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefupoSelect extends DeciTreeTemplateReadV2<RefupoInfo> {
	
	public RootRefupoSelect(DeciTreeOption<RefupoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefupoInfo> buildCheckerHook(DeciTreeOption<RefupoInfo> option) {
		List<ModelCheckerV1<RefupoInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefupoInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefupoCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<RefupoInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupoInfo> option) {
		List<ActionStdV2<RefupoInfo>> actions = new ArrayList<>();
		
		ActionStdV2<RefupoInfo> select = new StdRefupoDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
