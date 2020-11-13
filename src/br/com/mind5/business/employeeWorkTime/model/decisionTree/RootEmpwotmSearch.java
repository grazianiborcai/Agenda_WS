package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmRootSelect;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmMergeEmpwotarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootEmpwotmSearch extends DeciTreeTemplateReadV2<EmpwotmInfo> {
	
	public RootEmpwotmSearch(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpwotmInfo> buildCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelCheckerV1<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpwotmInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStdV1<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpwotmInfo> mergeEmpwotarch = new StdEmpwotmMergeEmpwotarch(option);
		ActionLazy<EmpwotmInfo> select = new LazyEmpwotmRootSelect(option.conn, option.schemaName);
		
		mergeEmpwotarch.addPostAction(select);
		
		actions.add(mergeEmpwotarch);
		return actions;
	}
}
