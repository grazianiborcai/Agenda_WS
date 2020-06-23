package br.com.mind5.business.scheduleLineSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.model.action.StdSchedinapSuccess;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckHasOrder;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSchedinapOrder extends DeciTreeTemplateWriteV2<SchedinapInfo> {
	
	public NodeSchedinapOrder(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedinapInfo> buildCheckerHook(DeciTreeOption<SchedinapInfo> option) {
		List<ModelCheckerV1<SchedinapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedinapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedinapCheckHasOrder(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedinapInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedinapInfo> option) {
		List<ActionStdV1<SchedinapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedinapInfo> success = new StdSchedinapSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<SchedinapInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedinapInfo> option) {
		List<ActionStdV1<SchedinapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedinapInfo> success = new StdSchedinapSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
