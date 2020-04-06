package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposDelete;
import br.com.mind5.business.employeePosition.model.action.LazyEmposEmptify;
import br.com.mind5.business.employeePosition.model.action.LazyEmposEnforceLChanged;
import br.com.mind5.business.employeePosition.model.action.LazyEmposMergeUsername;
import br.com.mind5.business.employeePosition.model.action.LazyEmposNodeEmposarch;
import br.com.mind5.business.employeePosition.model.action.LazyEmposUpdate;
import br.com.mind5.business.employeePosition.model.action.StdEmposMergeToDelete;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckDelete;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckExist;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckLangu;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckOwner;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckStorauth;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckStore;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmposDelete extends DeciTreeTemplateWrite<EmposInfo> {
	
	public RootEmposDelete(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelCheckerV1<EmposInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmposInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmposCheckDelete(checkerOption);
		queue.add(checker);		
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckOwner(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckStore(checkerOption);
		queue.add(checker);				
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<EmposInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV1<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmposInfo> mergeToDelete = new StdEmposMergeToDelete(option);
		ActionLazyV1<EmposInfo> enforceLChanged = new LazyEmposEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> enforceLChangedBy = new LazyEmposMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> update = new LazyEmposUpdate(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> delete = new LazyEmposDelete(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> emposarch = new LazyEmposNodeEmposarch(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> emptify = new LazyEmposEmptify(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		update.addPostAction(emposarch);
		update.addPostAction(emptify);
		
		actions.add(mergeToDelete);
		return actions;		
	}
}
