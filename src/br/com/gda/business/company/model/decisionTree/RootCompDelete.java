package br.com.gda.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.action.LazyCompDelete;
import br.com.gda.business.company.model.action.LazyCompEnforceLChanged;
import br.com.gda.business.company.model.action.LazyCompMergeUsername;
import br.com.gda.business.company.model.action.LazyCompUpdate;
import br.com.gda.business.company.model.action.StdCompMergeToDelete;
import br.com.gda.business.company.model.checker.CompCheckDelete;
import br.com.gda.business.company.model.checker.CompCheckExist;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCompDelete extends DeciTreeWriteTemplate<CompInfo> {
	
	public RootCompDelete(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompInfo> buildDecisionCheckerHook(DeciTreeOption<CompInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<CompInfo>> queue = new ArrayList<>();		
		ModelChecker<CompInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new CompCheckDelete();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
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
