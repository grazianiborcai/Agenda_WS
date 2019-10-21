package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.LazyCompDelete;
import br.com.mind5.business.company.model.action.LazyCompEnforceLChanged;
import br.com.mind5.business.company.model.action.LazyCompMergeUsername;
import br.com.mind5.business.company.model.action.LazyCompUpdate;
import br.com.mind5.business.company.model.action.StdCompMergeToDelete;
import br.com.mind5.business.company.model.checker.CompCheckDelete;
import br.com.mind5.business.company.model.checker.CompCheckExist;
import br.com.mind5.business.company.model.checker.CompCheckLangu;
import br.com.mind5.business.company.model.checker.CompCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCompDelete extends DeciTreeWriteTemplate<CompInfo> {
	
	public RootCompDelete(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompInfo> buildDecisionCheckerHook(DeciTreeOption<CompInfo> option) {
		List<ModelChecker<CompInfo>> queue = new ArrayList<>();		
		ModelChecker<CompInfo> checker;
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
		
		 return new ModelCheckerQueue<CompInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStd<CompInfo>> actions = new ArrayList<>();
		
		ActionStd<CompInfo> mergeToDelete = new StdCompMergeToDelete(option);	
		ActionLazy<CompInfo> enforceLChanged = new LazyCompEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<CompInfo> enforceLChangedBy = new LazyCompMergeUsername(option.conn, option.schemaName);
		ActionLazy<CompInfo> updateCompany = new LazyCompUpdate(option.conn, option.schemaName);
		ActionLazy<CompInfo> deleteCompany = new LazyCompDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateCompany);
		updateCompany.addPostAction(deleteCompany);
		
		actions.add(mergeToDelete);
		
		return actions;
	}
}
