package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.LazyCompDaoDelete;
import br.com.mind5.business.company.model.action.LazyCompEnforceLChanged;
import br.com.mind5.business.company.model.action.LazyCompMergeUsername;
import br.com.mind5.business.company.model.action.LazyCompDaoUpdate;
import br.com.mind5.business.company.model.action.StdCompMergeToDelete;
import br.com.mind5.business.company.model.checker.CompCheckDelete;
import br.com.mind5.business.company.model.checker.CompCheckExist;
import br.com.mind5.business.company.model.checker.CompCheckLangu;
import br.com.mind5.business.company.model.checker.CompCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCompDelete extends DeciTreeTemplateWriteV2<CompInfo> {
	
	public RootCompDelete(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CompInfo> buildCheckerHook(DeciTreeOption<CompInfo> option) {
		List<ModelCheckerV1<CompInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CompInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CompCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CompCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CompCheckLangu(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompCheckExist(checkerOption);
		queue.add(checker);		
		
		 return new ModelCheckerHelperQueueV2<CompInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStdV2<CompInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CompInfo> mergeToDelete = new StdCompMergeToDelete(option);	
		ActionLazy<CompInfo> enforceLChanged = new LazyCompEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<CompInfo> enforceLChangedBy = new LazyCompMergeUsername(option.conn, option.schemaName);
		ActionLazy<CompInfo> updateCompany = new LazyCompDaoUpdate(option.conn, option.schemaName);
		ActionLazy<CompInfo> deleteCompany = new LazyCompDaoDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateCompany);
		updateCompany.addPostAction(deleteCompany);
		
		actions.add(mergeToDelete);
		
		return actions;
	}
}
