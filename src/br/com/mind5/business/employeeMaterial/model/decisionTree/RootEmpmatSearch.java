package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatRootSelect;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatMergeEmpmarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootEmpmatSearch extends DeciTreeTemplateReadV2<EmpmatInfo> {
	
	public RootEmpmatSearch(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpmatInfo> buildCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		List<ModelCheckerV1<EmpmatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpmatInfo> checker;
			
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStdV2<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmpmatInfo> mergeEmpmarch = new StdEmpmatMergeEmpmarch(option);
		ActionLazy<EmpmatInfo> select = new LazyEmpmatRootSelect(option.conn, option.schemaName);
		
		mergeEmpmarch.addPostAction(select);
		
		actions.add(mergeEmpmarch);
		return actions;
	}
}
