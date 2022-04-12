package br.com.mind5.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiDaoInsert;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiDaoUpdate;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckSoftDelete;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StolateNodeUpsert extends DeciTreeTemplateWrite<StolateInfo> {
	
	public StolateNodeUpsert(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolateInfo> buildCheckerHook(DeciTreeOption<StolateInfo> option) {
		List<ModelChecker<StolateInfo>> queue = new ArrayList<>();		
		ModelChecker<StolateInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StolateCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStd<StolateInfo>> actions = new ArrayList<>();
		
		ActionStd<StolateInfo> insert = new ActionStdCommom<StolateInfo>(option, StolateVisiDaoInsert.class);
		
		actions.add(insert);				
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StolateInfo>> buildActionsOnFailedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStd<StolateInfo>> actions = new ArrayList<>();
		
		ActionStd<StolateInfo> update = new ActionStdCommom<StolateInfo>(option, StolateVisiDaoUpdate.class);
		
		actions.add(update);				
		return actions;
	}
}
