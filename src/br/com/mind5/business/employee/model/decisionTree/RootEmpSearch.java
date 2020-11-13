package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpMergeEmparch;
import br.com.mind5.business.employee.model.action.LazyEmpMergePerarch;
import br.com.mind5.business.employee.model.action.LazyEmpRootSelect;
import br.com.mind5.business.employee.model.action.StdEmpEnforcePersonKey;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.business.employee.model.checker.EmpCheckOwner;
import br.com.mind5.business.employee.model.checker.EmpCheckSearch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootEmpSearch extends DeciTreeTemplateReadV2<EmpInfo> {
	
	public RootEmpSearch(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelCheckerV1<EmpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpCheckSearch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV1<EmpInfo>> actions = new ArrayList<>();

		ActionStdV1<EmpInfo> enforcePersonKey = new StdEmpEnforcePersonKey(option);
		ActionLazy<EmpInfo> mergePerarch = new LazyEmpMergePerarch(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergeEmparch = new LazyEmpMergeEmparch(option.conn, option.schemaName);
		ActionLazy<EmpInfo> select = new LazyEmpRootSelect(option.conn, option.schemaName);
		
		enforcePersonKey.addPostAction(mergePerarch);
		mergePerarch.addPostAction(mergeEmparch);
		mergeEmparch.addPostAction(select);
		
		actions.add(enforcePersonKey);
		return actions;
	}
}
