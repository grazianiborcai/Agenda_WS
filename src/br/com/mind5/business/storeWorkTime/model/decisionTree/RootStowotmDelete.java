package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmDelete;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmEnforceLChanged;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmMergeUsername;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmUpdate;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmMergeToDelete;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckDelete;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckEmpwotarch;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckExist;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckStorauth;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStowotmDelete extends DeciTreeTemplateWrite<StowotmInfo> {
	
	public RootStowotmDelete(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StowotmInfo> buildCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelCheckerV1<StowotmInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StowotmInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotmCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotmCheckExist(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StowotmCheckEmpwotarch(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotmCheckStorauth(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerHelperQueueV2<StowotmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStdV1<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StowotmInfo> mergeToDelete = new StdStowotmMergeToDelete(option);
		ActionLazyV1<StowotmInfo> enforceLChanged = new LazyStowotmEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> enforceLChangedBy = new LazyStowotmMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> update = new LazyStowotmUpdate(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> delete = new LazyStowotmDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}
