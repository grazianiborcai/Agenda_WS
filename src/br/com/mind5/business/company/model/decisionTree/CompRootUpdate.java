package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.CompVisiEnforceLChanged;
import br.com.mind5.business.company.model.action.CompVisiEnforceNameSearch;
import br.com.mind5.business.company.model.action.CompVisiMergeToUpdate;
import br.com.mind5.business.company.model.action.CompVisiMergeUsername;
import br.com.mind5.business.company.model.action.CompVisiNodeCnpjL1;
import br.com.mind5.business.company.model.action.CompVisiNodeSnapshot;
import br.com.mind5.business.company.model.checker.CompCheckCountry;
import br.com.mind5.business.company.model.checker.CompCheckExist;
import br.com.mind5.business.company.model.checker.CompCheckLangu;
import br.com.mind5.business.company.model.checker.CompCheckName;
import br.com.mind5.business.company.model.checker.CompCheckNameLength;
import br.com.mind5.business.company.model.checker.CompCheckOwner;
import br.com.mind5.business.company.model.checker.CompCheckRazaoSocial;
import br.com.mind5.business.company.model.checker.CompCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CompRootUpdate extends DeciTreeTemplateWrite<CompInfo> {
	
	public CompRootUpdate(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompInfo> buildCheckerHook(DeciTreeOption<CompInfo> option) {
		List<ModelChecker<CompInfo>> queue = new ArrayList<>();		
		ModelChecker<CompInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CompCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new CompCheckNameLength(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompCheckName(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompCheckRazaoSocial(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompCheckCountry(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompCheckExist(checkerOption);
		queue.add(checker);	
			
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStd<CompInfo>> actions = new ArrayList<>();
		
		ActionStd<CompInfo> mergeToUpdate = new ActionStdCommom<CompInfo>(option, CompVisiMergeToUpdate.class);	
		ActionLazy<CompInfo> cnpj = new ActionLazyCommom<CompInfo>(option, CompVisiNodeCnpjL1.class);	
		ActionLazy<CompInfo> enforceLChanged = new ActionLazyCommom<CompInfo>(option, CompVisiEnforceLChanged.class);
		ActionLazy<CompInfo> enforceLChangedBy = new ActionLazyCommom<CompInfo>(option, CompVisiMergeUsername.class);
		ActionLazy<CompInfo> enforceNameSearch = new ActionLazyCommom<CompInfo>(option, CompVisiEnforceNameSearch.class);
		ActionLazy<CompInfo> snapshot = new ActionLazyCommom<CompInfo>(option, CompVisiNodeSnapshot.class);
		
		mergeToUpdate.addPostAction(cnpj);
		cnpj.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceNameSearch);
		enforceNameSearch.addPostAction(snapshot);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
