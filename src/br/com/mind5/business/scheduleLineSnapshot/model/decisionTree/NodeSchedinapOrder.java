package br.com.mind5.business.scheduleLineSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.model.action.StdSchedinapSuccess;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckHasOrder;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeSchedinapOrder extends DeciTreeTemplateWrite<SchedinapInfo> {
	
	public NodeSchedinapOrder(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedinapInfo> buildCheckerHook(DeciTreeOption<SchedinapInfo> option) {
		List<ModelChecker<SchedinapInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedinapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedinapCheckHasOrder(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedinapInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedinapInfo> option) {
		List<ActionStd<SchedinapInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedinapInfo> success = new StdSchedinapSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedinapInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedinapInfo> option) {
		List<ActionStd<SchedinapInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedinapInfo> success = new StdSchedinapSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
