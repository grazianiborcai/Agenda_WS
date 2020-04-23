package br.com.mind5.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateMergeStolis;
import br.com.mind5.business.storeLeaveDate.model.action.StdStolateMergeToSelect;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckLangu;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckOwner;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckRead;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckStorauth;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckStore;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootStolateSelect extends DeciTreeTemplateReadV2<StolateInfo> {
	
	public RootStolateSelect(DeciTreeOption<StolateInfo> option) {
		super(option);
	}	
	
	
	@Override protected ModelCheckerV1<StolateInfo> buildCheckerHook(DeciTreeOption<StolateInfo> option) {
		List<ModelCheckerV1<StolateInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StolateInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StolateCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolateCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolateCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolateCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolateCheckStorauth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStdV1<StolateInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StolateInfo> mergeToSelect = new StdStolateMergeToSelect(option);
		ActionLazyV1<StolateInfo> mergeStolis = new LazyStolateMergeStolis(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeStolis);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
