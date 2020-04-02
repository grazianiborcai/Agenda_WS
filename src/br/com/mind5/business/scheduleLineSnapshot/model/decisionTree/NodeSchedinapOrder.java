package br.com.mind5.business.scheduleLineSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.model.action.StdSchedinapSuccess;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckHasOrder;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedinapOrder extends DeciTreeWriteTemplate<SchedinapInfo> {
	
	public NodeSchedinapOrder(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedinapInfo> buildDecisionCheckerHook(DeciTreeOption<SchedinapInfo> option) {
		List<ModelChecker<SchedinapInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedinapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedinapCheckHasOrder(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
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
