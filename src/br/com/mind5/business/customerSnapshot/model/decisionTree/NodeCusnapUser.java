package br.com.mind5.business.customerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.model.action.StdCusnapMergeUselis;
import br.com.mind5.business.customerSnapshot.model.action.StdCusnapSuccess;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckHasUser;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeCusnapUser extends DeciTreeTemplateReadV2<CusnapInfo> {
	
	public NodeCusnapUser(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusnapInfo> buildCheckerHook(DeciTreeOption<CusnapInfo> option) {
		List<ModelCheckerV1<CusnapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusnapInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusnapCheckHasUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CusnapInfo> option) {
		List<ActionStdV1<CusnapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusnapInfo> mergeUselis = new StdCusnapMergeUselis(option);
		
		actions.add(mergeUselis);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<CusnapInfo>> buildActionsOnFailedHook(DeciTreeOption<CusnapInfo> option) {
		List<ActionStdV1<CusnapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusnapInfo> success = new StdCusnapSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
